package mn.erin.ees.dms.domain.document.repository.alfresco_repository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.alfresco.core.handler.NodesApi;
import org.alfresco.core.handler.QueriesApi;
import org.alfresco.core.model.Node;
import org.alfresco.core.model.NodeBodyCreate;
import org.alfresco.core.model.NodeChildAssociation;
import org.alfresco.core.model.NodeChildAssociationEntry;
import org.alfresco.core.model.NodeChildAssociationPaging;
import org.alfresco.core.model.NodeEntry;
import org.alfresco.core.model.NodePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.AlfrescoConstants;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.DocumentGettingException;
import mn.erin.ees.dms.utilities.ExceptionReason;

/**
 * @author Altanbagana
 */

@Repository
public class DocumentRepositoryAlfrescoImpl implements DocumentRepository
{
  private final NodesApi nodesApi;
  private final QueriesApi queriesApi;

  @Autowired
  public DocumentRepositoryAlfrescoImpl(NodesApi nodesApi, QueriesApi queriesApi)
  {
    this.nodesApi = nodesApi;
    this.queriesApi = queriesApi;
  }

  @Override
  public String upload(Document document) throws DocumentCreationException
  {
    Node createdNode = createNode(document);
    ResponseEntity<NodeEntry> responseEntity;
    try
    {
      responseEntity = nodesApi.updateNodeContent(createdNode.getId(), document.getResource().getInputStream().readAllBytes(), null, null, null, null, null);
    }
    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, e.getMessage());
    }

    if (responseEntity.getStatusCode() != HttpStatus.OK)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Not saved file");
    }
    return createdNode.getId();
  }

  @Override
  public Document findByReferrerIdAndName(String referrerId, String name) throws DocumentGettingException
  {
    String folderId = findNodeIdByNameAndType(referrerId, AlfrescoConstants.FOLDER);
    NodeChildAssociation node = findChildNode(folderId, name);
    if (node == null)
    {
      throw new DocumentGettingException(ExceptionReason.NOT_FOUND, name + " was not found in the folder with the ID: [" + folderId + "]");
    }

    return convertToDocument(node, downloadByContentId(node.getId()));
  }

  @Override
  public List<Document> findAllByReferrerId(String referrerId) throws DocumentGettingException
  {
    String folderId = findNodeIdByNameAndType(referrerId, AlfrescoConstants.FOLDER);
    List<NodeChildAssociationEntry> nodeChildAssociationEntries = listNodeChildren(folderId);

    return nodeChildAssociationEntries.stream().map(
            nodeChildAssociationEntry -> convertToDocument(nodeChildAssociationEntry.getEntry(), downloadByContentId(nodeChildAssociationEntry.getEntry().getId())))
        .collect(Collectors.toList());
  }

  @Override
  public Resource downloadByContentId(String contentId)
  {
    ResponseEntity<Resource> responseEntity = nodesApi.getNodeContent(contentId, null, null, null);
    if (responseEntity.getStatusCode() != HttpStatus.OK)
    {
      return null;
    }

    return responseEntity.getBody();
  }

  @Override
  public void deleteById(String contentId)
  {

  }

  private Node createNode(Document document) throws DocumentCreationException
  {
    ResponseEntity<NodeEntry> responseEntity = nodesApi.createNode(
        AlfrescoConstants.ALFRESCO_ROOT,
        new NodeBodyCreate()
            .properties(setProperties(document))
            .name(document.getDocumentName())
            .nodeType(AlfrescoConstants.CONTENT)
            .relativePath(
                AlfrescoConstants.ERIN_ROOT +
                    document.getOrganizationId() + "/" +
                    document.getGroupId() + "/" +
                    document.getCreatedDate().getYear() + "/" +
                    document.getCreatedDate().getMonthValue() + "/" +
                    document.getReferrerId()),
        null, null, null, null, null);

    if (responseEntity.getStatusCode() != HttpStatus.CREATED)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Failed to save a file");
    }

    if (!responseEntity.hasBody())
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Response entity has no body!");
    }

    return Objects.requireNonNull(responseEntity.getBody()).getEntry();
  }

  private NodeChildAssociation findChildNode(String parentId, String childName) throws DocumentGettingException
  {
    List<NodeChildAssociationEntry> nodeChildAssociationEntries = listNodeChildren(parentId);

    for (NodeChildAssociationEntry entry : nodeChildAssociationEntries)
    {
      if (childName.equals(entry.getEntry().getName()))
      {
        return entry.getEntry();
      }
    }

    return null;
  }

  private List<NodeChildAssociationEntry> listNodeChildren(String parentId) throws DocumentGettingException
  {
    String[] include = {"properties"};
    ResponseEntity<NodeChildAssociationPaging> responseEntity = nodesApi.listNodeChildren(parentId, null, 50000, null, null, List.of(include), null, null, null);
    if (responseEntity.getStatusCode() != HttpStatus.OK)
    {
      throw new DocumentGettingException(ExceptionReason.NOT_FOUND, "document not found!");
    }

    NodeChildAssociationPaging nodeChildAssociationPaging = responseEntity.getBody();

    if (nodeChildAssociationPaging == null || nodeChildAssociationPaging.getList() == null)
    {
      return Collections.emptyList();
    }

    return nodeChildAssociationPaging.getList().getEntries();
  }

  private String findNodeIdByNameAndType(String name, String type) throws DocumentGettingException
  {
    ResponseEntity<NodePaging> responseEntity = queriesApi.findNodes(name, null, null, null, type, null, null, null);

    if (responseEntity.getStatusCode() != HttpStatus.OK)
    {
      throw new DocumentGettingException(ExceptionReason.NOT_FOUND, "Not found file");
    }

    if (!responseEntity.hasBody())
    {
      throw new DocumentGettingException(ExceptionReason.NOT_FOUND, "response entity has no body");
    }

    return Objects.requireNonNull(responseEntity.getBody()).getList().getEntries().get(0).getEntry().getId();
  }

  private Map<String, String> setProperties(Document document)
  {
    Map<String, String> properties = new HashMap<>();
    properties.put(AlfrescoConstants.ORGANIZATION_ID, document.getOrganizationId());
    properties.put(AlfrescoConstants.GROUP_ID, document.getGroupId());
    properties.put(AlfrescoConstants.CREATED_DATE, document.getCreatedDate().toString());
    properties.put(AlfrescoConstants.CREATED_USER, document.getCreatedUser());
    properties.put(AlfrescoConstants.DESCRIPTION, document.getDescription());
    properties.put(AlfrescoConstants.REFERRER_ID, document.getReferrerId());
    properties.put(AlfrescoConstants.DOCUMENT_TYPE, document.getDocumentType());
    return properties;
  }

  private Document convertToDocument(NodeChildAssociation node, Resource resource)
  {
    //TODO: fix unchecked or unsafe operations
    Map<String, String> properties = (Map<String, String>) node.getProperties();
    return new Document(
        node.getId(),
        node.getName(),
        properties.get(AlfrescoConstants.ORGANIZATION_ID),
        properties.get(AlfrescoConstants.GROUP_ID),
        properties.get(AlfrescoConstants.CREATED_USER),
        properties.get(AlfrescoConstants.DOCUMENT_TYPE),
        LocalDate.parse(properties.get(AlfrescoConstants.CREATED_DATE)),
        properties.get(AlfrescoConstants.REFERRER_ID),
        properties.get(AlfrescoConstants.DESCRIPTION),
        resource);
  }
}
