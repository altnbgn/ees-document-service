package mn.erin.ees.dms.domain.document_type.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.model.DocumentTypeInput;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.domain.document_type.usecase.CreateDocumentType;
import mn.erin.ees.dms.domain.document_type.usecase.GetDocumentTypes;
import mn.erin.ees.dms.rest.DocumentTypeApiDelegate;
import mn.erin.ees.dms.rest.model.CreateDocumentTypeResponseRestModel;
import mn.erin.ees.dms.rest.model.DocumentTypePayloadRestModel;
import mn.erin.ees.dms.rest.model.DocumentTypeRestModel;
import mn.erin.ees.dms.rest.model.DocumentTypesResponseRestModel;
import mn.erin.ees.dms.rest.model.GenericErrorRestModel;
import mn.erin.ees.dms.utilities.CreateDocumentTypeException;

@Component
public class DocumentTypeRestService implements DocumentTypeApiDelegate
{
  private final DocumentTypeRepository documentTypeRepository;

  public DocumentTypeRestService(DocumentTypeRepository documentTypeRepository)
  {
    this.documentTypeRepository = documentTypeRepository;
  }

  @Override
  public ResponseEntity<CreateDocumentTypeResponseRestModel> createDocumentType(String organizationId,
      DocumentTypePayloadRestModel documentTypePayloadRestModel)
  {
    CreateDocumentType createDocumentType = new CreateDocumentType(documentTypeRepository);
    try
    {
      DocumentTypeInput input = new DocumentTypeInput(organizationId,
          documentTypePayloadRestModel.getGroupId(),
          documentTypePayloadRestModel.getName(),
          documentTypePayloadRestModel.getCategory(),
          documentTypePayloadRestModel.getDescription());

      return ResponseEntity.ok(new CreateDocumentTypeResponseRestModel().id(createDocumentType.execute(input).getId()));
    }
    catch (CreateDocumentTypeException e)
    {
      ResponseEntity.internalServerError().body(new CreateDocumentTypeResponseRestModel().error(new GenericErrorRestModel().message(e.getMessage())));
    }
    return null;
  }

  @Override
  public ResponseEntity<DocumentTypesResponseRestModel> getDocumentTypes(String organizationId, String groupId)
  {
    GetDocumentTypes getDocumentTypes = new GetDocumentTypes(documentTypeRepository);
    try
    {
      List<DocumentType> documentTypes = getDocumentTypes.execute(organizationId, groupId);
      return ResponseEntity.ok(
          new DocumentTypesResponseRestModel().documents(documentTypes.stream().map(this::mapToDocumentTypeRestModel).collect(Collectors.toList())));
    }
    catch (Exception e)
    {
      return ResponseEntity.internalServerError().body(new DocumentTypesResponseRestModel().error(new GenericErrorRestModel().message(e.getMessage())));
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


