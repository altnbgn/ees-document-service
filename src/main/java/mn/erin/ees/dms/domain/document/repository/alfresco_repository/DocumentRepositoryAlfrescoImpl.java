package mn.erin.ees.dms.domain.document.repository.alfresco_repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;

import org.openapitools.client.ApiException;
import org.openapitools.client.api.ActionsApi;
import org.openapitools.client.api.NodesApi;
import org.openapitools.client.model.Node;
import org.openapitools.client.model.NodeBodyCreate;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.utilities.AlfrescoNodeConstants;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

/**
 * @author Altanbagana
 */

@Repository
public class DocumentRepositoryAlfrescoImpl implements DocumentRepository
{
  private final NodesApi nodesApi;
  private final ActionsApi actionsApi;

  public DocumentRepositoryAlfrescoImpl()
  {
    this.nodesApi = new AlfrescoClient().getNodesApi();

    this.actionsApi = new AlfrescoClient().getActionsApi();
  }

  @Override
  public String fileSave(DocumentInput input, DocumentType documentType) throws DocumentCreationException
  {
    Node createdNode = createNode(input, documentType);
    try
    {
      nodesApi.updateNodeContent(createdNode.getId(), convertToFile(input.getFile()), null, null, null, null, null);
    }
    catch (ApiException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Api exception");
    }

    return createdNode.getId();
  }

  @Override
  public List<Document> get(String organizationId, String groupId)
  {
    return null;
  }

  @Override
  public Resource fileDownload(String contentId) throws DocumentCreationException
  {
    try
    {
      return new ByteArrayResource(Files.readAllBytes(nodesApi.getNodeContent(contentId, null, null, null).toPath()));
    }
    catch (ApiException e)
    {
      throw new DocumentCreationException(ExceptionReason.CANNOT_USE_API, "cannot use api");
    }
    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, "cannot read bytes from file");
    }
  }

  @Override
  public void deleteById(String contentId)
  {

  }

  Node createNode(DocumentInput input, DocumentType documentType) throws DocumentCreationException
  {
    try
    {
      return nodesApi.createNode(
              AlfrescoNodeConstants.ALFRESCO_ROOT,
              new NodeBodyCreate()
                  .name(input.getDocumentName())
                  .nodeType(AlfrescoNodeConstants.CONTENT)
                  .relativePath(
                      AlfrescoNodeConstants.ERIN_ROOT +
                          input.getOrganizationId() + "/" +
                          input.getGroupId() + "/" +
                          input.getCreatedDate().getYear() + "/" +
                          input.getCreatedDate().getMonthValue() + "/" +
                          documentType.getName()),
              null, null, null, null, null)
          .getEntry();
    }
    catch (ApiException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, e.getMessage());
    }
  }

  File convertToFile(MultipartFile multipartFile) throws DocumentCreationException
  {
    File file = new File(multipartFile.getName());
    try (OutputStream os = new FileOutputStream(file))
    {
      os.write(multipartFile.getBytes());
    }

    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, e.getMessage());
    }
    file.deleteOnExit();
    return file;
  }
}
