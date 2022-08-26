package mn.erin.ees.dms.domain.document.api;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.usecase.CreateDocument;
import mn.erin.ees.dms.domain.document.usecase.DocumentDownloadDeleteRepository;
import mn.erin.ees.dms.domain.document.usecase.DocumentRepository;
import mn.erin.ees.dms.domain.document.usecase.DownloadDocument;
import mn.erin.ees.dms.domain.document.usecase.GetDocuments;
import mn.erin.ees.dms.domain.document_type.usecase.DocumentTypeRepository;
import mn.erin.ees.dms.rest.DocumentApiDelegate;
import mn.erin.ees.dms.rest.model.DocumentRestModel;
import mn.erin.ees.dms.rest.model.ErrorRestModel;
import mn.erin.ees.dms.utilities.DocumentCreationException;

@Component
@Service
public class DocumentsRestService implements DocumentApiDelegate
{
  @Autowired
  private DocumentRepository documentRepository;

  @Autowired
  private DocumentDownloadDeleteRepository documentDownloadDeleteRepository;
  @Autowired
  private DocumentTypeRepository documentTypeRepository;

  @Autowired
  private GridFsTemplate gridFsTemplate;

  @Override
  public ResponseEntity<DocumentRestModel> createDocument(String organizationId, String groupId, String documentName, String createdUser, String documentType,
      String createDate, String description, MultipartFile file)
  {
    try
    {
      LocalDate date = LocalDate.parse(createDate);
      Document document = new CreateDocument(documentRepository, documentTypeRepository, gridFsTemplate, documentDownloadDeleteRepository).execute(
          new DocumentInput(organizationId, groupId, documentName, createdUser, documentType,
              date, description, file));
      // todo convert document to document rest model
      DocumentRestModel documentRestModel = new DocumentRestModel();
      return ResponseEntity.created(URI.create("id")).body(documentRestModel);
    }
    catch (DocumentCreationException e)
    {
      return (ResponseEntity) ResponseEntity.badRequest().body(new ErrorRestModel().reason(e.reason.name()).message(e.getMessage()));
    }
    catch (IOException e)
    {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ResponseEntity<List<DocumentRestModel>> getDocuments(String organizationId, String groupId)
  {
    GetDocuments getDocuments = new GetDocuments(documentRepository);
    try
    {
      List<Document> documentsList = getDocuments.execute(organizationId, groupId);
      List<DocumentRestModel> documents = new ArrayList<>();
      for (Document document1 : documentsList)
      {
        documents.add(mapToDocumentRestModel(document1));
      }
      return ResponseEntity.ok(documents);
    }
    catch (Exception e)
    {
      return (ResponseEntity) ResponseEntity.badRequest().body(e);
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
        .file(document.getFile())
        .path(document.getPath());
  }
  @Override
  public ResponseEntity<org.springframework.core.io.Resource> getFile(String contentId) {
    DownloadDocument downloadDocument = new DownloadDocument(documentDownloadDeleteRepository);
        try
        {
          GridFsResource data = downloadDocument.execute(contentId);
          return ResponseEntity.ok(data);
        }
        catch (Exception e)
        {
          return (ResponseEntity) ResponseEntity.badRequest().body(e);
        }
  }
}