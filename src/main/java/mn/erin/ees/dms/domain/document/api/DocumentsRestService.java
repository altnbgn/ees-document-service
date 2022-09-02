package mn.erin.ees.dms.domain.document.api;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.repository.DocumentMetaRepositoryImpl;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document.usecase.CreateDocument;
import mn.erin.ees.dms.domain.document.usecase.DownloadDocument;
import mn.erin.ees.dms.domain.document.usecase.GetDocuments;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.rest.DocumentApiDelegate;
import mn.erin.ees.dms.rest.model.DocumentCreationResponseRestModel;
import mn.erin.ees.dms.rest.model.DocumentRestModel;
import mn.erin.ees.dms.rest.model.DocumentsRestModel;
import mn.erin.ees.dms.rest.model.ErrorRestModel;
import mn.erin.ees.dms.rest.model.GetFileResponseRestModel;
import mn.erin.ees.dms.utilities.DocumentCreationException;

@Component
@Service
public class DocumentsRestService implements DocumentApiDelegate
{
  private final DocumentRepository documentRepository;
  private final DocumentTypeRepository documentTypeRepository;
  private final DocumentMetaRepositoryImpl documentMetaRepositoryImpl;

  public DocumentsRestService(DocumentRepository documentRepository, DocumentTypeRepository documentTypeRepository,
      DocumentMetaRepositoryImpl documentMetaRepositoryImpl)
  {
    this.documentRepository = documentRepository;
    this.documentTypeRepository = documentTypeRepository;
    this.documentMetaRepositoryImpl = documentMetaRepositoryImpl;
  }

  @Override
  public ResponseEntity<DocumentCreationResponseRestModel> upload(String organizationId, String groupId, String createdUser, String documentName,
      String documentType,
      String createdDate, String description, MultipartFile file)
  {
    try
    {
      LocalDate date = LocalDate.parse(createdDate);
      String documentId = new CreateDocument(documentRepository, documentTypeRepository, documentMetaRepositoryImpl).execute(
          new DocumentInput(organizationId, groupId, documentName, createdUser, documentType, date, description, file));
      return ResponseEntity.created(URI.create("id")).body(new DocumentCreationResponseRestModel().id(documentId));
    }
    catch (DocumentCreationException e)
    {
      return ResponseEntity.internalServerError().body(new DocumentCreationResponseRestModel().error(new ErrorRestModel().message(e.getMessage())));
    }
  }

  @Override
  public ResponseEntity<DocumentsRestModel> getDocuments(String organizationId, String groupId)
  {
    GetDocuments getDocuments = new GetDocuments(documentRepository);
    try
    {
      List<Document> documentsList = getDocuments.execute(organizationId, groupId);
      return ResponseEntity.ok(new DocumentsRestModel().documents(documentsList.stream().map(this::mapToDocumentRestModel).collect(Collectors.toList())));
    }

    catch (Exception e)
    {
      return ResponseEntity.internalServerError().body(new DocumentsRestModel().error(new ErrorRestModel().message(e.getMessage())));
    }
  }

  @Override
  public ResponseEntity<Resource> download(String contentId)
  {
    DownloadDocument downloadDocument = new DownloadDocument(documentRepository, documentMetaRepositoryImpl);
    try
    {
      return ResponseEntity.ok(downloadDocument.execute(contentId).getFileResource());
    }
    catch (Exception e)
    {
      return null;
    }
  }

  private DocumentRestModel mapToDocumentRestModel(Document document)
  {
    return new DocumentRestModel()
        .id(document.getId())
        .organizationId(document.getOrganizationId())
        .groupId(document.getGroupId())
        .name(document.getDocumentName())
        .type(document.getType())
        .createdUser(document.getCreatedUser())
        .date(document.getCreatedDate().toString())
        .file(document.getFileName())
        .path(document.getContentId());
  }
}