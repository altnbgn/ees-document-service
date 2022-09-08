package mn.erin.ees.dms.domain.document.api;

import java.net.URI;
import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document.usecase.CreateDocument;
import mn.erin.ees.dms.domain.document.usecase.GetAllDocumentsByJournalEntryId;
import mn.erin.ees.dms.domain.document.usecase.GetDocument;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.rest.DocumentApiDelegate;
import mn.erin.ees.dms.rest.model.DocumentCreationResponseRestModel;
import mn.erin.ees.dms.rest.model.DocumentOutputResponseRestModel;
import mn.erin.ees.dms.rest.model.DocumentOutputRestModel;
import mn.erin.ees.dms.rest.model.DocumentOutputsRestModel;
import mn.erin.ees.dms.rest.model.DocumentRestModel;
import mn.erin.ees.dms.rest.model.ErrorRestModel;
import mn.erin.ees.dms.utilities.DocumentCreationException;

@Component
@Service
public class DocumentsRestService implements DocumentApiDelegate
{
  private final DocumentRepository documentRepository;
  private DocumentTypeRepository documentTypeRepository;

  public DocumentsRestService(DocumentRepository documentRepository/*, DocumentTypeRepository documentTypeRepository*/)
  {
    this.documentRepository = documentRepository;
    //    this.documentTypeRepository = documentTypeRepository;
  }

  @Override
  public ResponseEntity<DocumentCreationResponseRestModel> upload(String organizationId, String groupId, String createdUser, String documentName,
      String documentType, String createdDate, String description, String journalEntryId, MultipartFile file)
  {
    try
    {
      LocalDate date = LocalDate.parse(createdDate);
      String documentId = new CreateDocument(documentRepository, documentTypeRepository).execute(
          new DocumentInput(organizationId, groupId, documentName, createdUser, documentType, date, description, journalEntryId, file));
      return ResponseEntity.created(URI.create("id")).body(new DocumentCreationResponseRestModel().id(documentId));
    }
    catch (DocumentCreationException e)
    {
      return ResponseEntity.internalServerError().body(new DocumentCreationResponseRestModel().error(new ErrorRestModel().message(e.getMessage())));
    }
  }

  @Override
  public ResponseEntity<DocumentOutputResponseRestModel> downloadDocument(String journalEntryId, String name)
  {
    GetDocument getDocument = new GetDocument(documentRepository);
    return ResponseEntity.ok(
        new DocumentOutputResponseRestModel().documentOutput(convertToDocumentOutputRestModel(getDocument.execute(journalEntryId, name))));
  }

  @Override
  public ResponseEntity<DocumentOutputsRestModel> downloadAllDocuments(String journalEntryId)
  {
    return ResponseEntity.ok(new DocumentOutputsRestModel().documentOutputs(
        new GetAllDocumentsByJournalEntryId(documentRepository).execute(journalEntryId).stream().map(this::convertToDocumentOutputRestModel)
            .collect(Collectors.toList())));
  }

  private DocumentRestModel convertToDocumentRestModel(Document document)
  {
    return new DocumentRestModel()
        .id(document.getId())
        .organizationId(document.getOrganizationId())
        .groupId(document.getGroupId())
        .name(document.getDocumentName())
        .type(document.getDocumentType())
        .createdUser(document.getCreatedUser())
        .date(document.getCreatedDate().toString())
        .referrerId(document.getReferrerId());
  }

  private DocumentOutputRestModel convertToDocumentOutputRestModel(DocumentOutput documentOutput)
  {
    return new DocumentOutputRestModel()
        .contentId(documentOutput.getContentId())
        .contentTypeId(documentOutput.getContentTypeId())
        .name(documentOutput.getName());
  }
}