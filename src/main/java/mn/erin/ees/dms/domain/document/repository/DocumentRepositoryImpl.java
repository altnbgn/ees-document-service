package mn.erin.ees.dms.domain.document.repository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.usecase.DocumentDownloadDeleteRepository;
import mn.erin.ees.dms.domain.document.usecase.DocumentRepository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class DocumentRepositoryImpl implements DocumentRepository, DocumentDownloadDeleteRepository
{
  private final MongoDocumentRepository mongoDocumentRepository;
  private DocumentFileSaveRepository documentFileSave;
  private GridFsTemplate gridFsTemplate;

  public DocumentRepositoryImpl(MongoDocumentRepository mongoDocumentRepository, DocumentFileSaveRepository documentFileSaveRepository, GridFsTemplate gridFsTemplate)
  {
    this.documentFileSave = documentFileSaveRepository;
    this.mongoDocumentRepository = mongoDocumentRepository;
    this.gridFsTemplate=gridFsTemplate;
  }

  @Override
  public Document save(String organizationId, String groupId, String documentType, String documentName, String createdUser,
      LocalDate date, String description, String fileName, String contentId)
  {
    MongoDocument mongoDocument = new MongoDocument(
        organizationId,
        groupId,
        documentName,
        documentType,
        createdUser,
        date,
        description,
        fileName,
        contentId);
      MongoDocument mongoDocument1 = mongoDocumentRepository.save(mongoDocument);
      return mapper(mongoDocument1);
  }

  @Override
  public void deleteById(String contentId)
  {
    gridFsTemplate.delete(Query.query(where("_id").is(contentId)));
  }

  @Override
  public String fileSave(MultipartFile file) throws IOException
  {
    ObjectId contentId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename());
    return contentId.toString();
  }

  @Override
  public GridFsResource fileDownload(String contentId)
  {
    GridFSFile file = gridFsTemplate.findOne(Query.query(where("_id").is(contentId)));
    return gridFsTemplate.getResource(file);
  }
  @Override
  public List<Document> get(String organizationId, String groupId)
  {
    Iterable<MongoDocument> mongoDocumentList = mongoDocumentRepository.findAllByOrganizationIdAndGroupId(organizationId, groupId);
    List<Document> documentArrayList = new ArrayList<>();

    for (MongoDocument mongoDocument : mongoDocumentList)
    {
      documentArrayList.add(mapper(mongoDocument));
    }
    return documentArrayList;
  }

  public Document mapper(MongoDocument mongoDocument)
  {
    Document document = new Document(mongoDocument.getId(),
        mongoDocument.getOrganizationId(),
        mongoDocument.getGroupId(),
        mongoDocument.getDocumentName(),
        mongoDocument.getDocumentType(),
        mongoDocument.getCreatedBy(),
        mongoDocument.getDate(),
        mongoDocument.getFileName(),
        mongoDocument.getContentId().toString());
    document.setDescription(mongoDocument.getDescription());
    return document;
  }
}
