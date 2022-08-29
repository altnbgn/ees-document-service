package mn.erin.ees.dms.domain.document_type.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.model.DocumentTypeInput;
import mn.erin.ees.dms.domain.document_type.usecase.CreateDocumentType;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.domain.document_type.usecase.GetDocumentTypes;
import mn.erin.ees.dms.rest.DocumentTypeApiDelegate;
import mn.erin.ees.dms.rest.model.DocumentTypePayloadRestModel;
import mn.erin.ees.dms.rest.model.DocumentTypeRestModel;
import mn.erin.ees.dms.rest.model.ErrorRestModel;
import mn.erin.ees.dms.utilities.CreateDocumentTypeException;

@Component
public class DocumentTypeRestService implements DocumentTypeApiDelegate
{
  private final DocumentTypeRepository documentTypeRepository;
  private static DocumentType documentType;

  public DocumentTypeRestService(DocumentTypeRepository documentTypeRepository)
  {
    this.documentTypeRepository = documentTypeRepository;
  }

  @Override
  public ResponseEntity<DocumentTypeRestModel> createDocumentType(String organizationId, DocumentTypePayloadRestModel documentTypePayloadRestModel) {
        CreateDocumentType createDocumentType = new CreateDocumentType(documentTypeRepository);
    try
    {
      DocumentTypeInput input = new DocumentTypeInput(organizationId,
          documentTypePayloadRestModel.getGroupId(),
          documentTypePayloadRestModel.getName(),
          documentTypePayloadRestModel.getCategory(),
          documentTypePayloadRestModel.getDescription());

      DocumentType documentType = createDocumentType.execute(input);

      DocumentTypeRestModel restModel = new DocumentTypeRestModel();
      restModel.setId(documentType.getId());
      restModel.setCreatedBy(documentType.getCreatedBy());
      restModel.setOrganizationId(documentType.getOrganizationId());
      restModel.setGroupId(documentType.getGroupId());
      restModel.setCategory(documentType.getCategory());
      restModel.setName(documentType.getName());
      restModel.setDescription(documentType.getDescription());

      return ResponseEntity.created(URI.create(documentType.getId())).body(restModel);
    }
    catch (CreateDocumentTypeException e)
    {
      return (ResponseEntity) ResponseEntity.badRequest().body(new ErrorRestModel().reason(e.reason.name()).message(e.getMessage()));
    }
  }

  @Override
  public ResponseEntity<List<DocumentTypeRestModel>> getDocumentTypes(String organizationId, String groupId)
  {
    GetDocumentTypes getDocumentTypes = new GetDocumentTypes(documentTypeRepository);
    try
    {
      List<DocumentType> documentTypes = getDocumentTypes.execute(organizationId, groupId);
      List<DocumentTypeRestModel> response = new ArrayList<>();
      for (DocumentType documentType1 : documentTypes)
      {
        response.add(mapToDocumentTypeRestModel(documentType1));
      }
      return ResponseEntity.ok(response);
    }
    catch (Exception e)
    {
      return (ResponseEntity) ResponseEntity.badRequest().body(e);
    }
  }

  private DocumentTypeRestModel mapToDocumentTypeRestModel(DocumentType type)
  {
    return new DocumentTypeRestModel()
        .id(type.getId())
        .createdBy(type.getCreatedBy())
        .organizationId(type.getOrganizationId())
        .groupId(type.getGroupId())
        .category(type.getCategory())
        .name(type.getName())
        .description(type.getDescription());
  }
}


