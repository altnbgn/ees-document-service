package mn.erin.ees.dms.domain.document.repository.mongo_repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class DocumentRepositoryImpl implements DocumentRepository, DocumentDownloadDeleteRepository
{
  private final MongoDocumentRepository mongoDocumentRepository;
  private GridFsTemplate gridFsTemplate;

  public DocumentRepositoryImpl(MongoDocumentRepository mongoDocumentRepository, GridFsTemplate gridFsTemplate)
  {
    this.mongoDocumentRepository = mongoDocumentRepository;
    this.gridFsTemplate = gridFsTemplate;
  }

  @Override
  public void deleteById(String contentId)
  {
    gridFsTemplate.delete(Query.query(where("_id").is(contentId)));
  }

  @Override
  public Document fileSave(DocumentInput input, DocumentType documentType) throws IOException
  {
    if (null == input.getFile() || null == input.getFile().getOriginalFilename())
    {
      return null;
    }
    ObjectId contentId = gridFsTemplate.store(input.getFile().getInputStream(), input.getFile().getOriginalFilename());
    MongoDocument mongoDocument = new MongoDocument(
        input.getOrganizationId(),
        input.getGroupId(),
        documentType.getName(),
        input.getDocumentType(),
        input.getCreatedUser(),
        input.getCreatedDate(),
        input.getDescription(),
        input.getFile().getName(),
        contentId.toString());
    MongoDocument createdMongoDocument = mongoDocumentRepository.save(mongoDocument);
    return mapper(createdMongoDocument);
  }

  @Override
  public GridFsResource fileDownload(String contentId)
  {
    GridFSFile file = gridFsTemplate.findOne(Query.query(where("_id").is(contentId)));
    assert file != null;
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
        mongoDocument.getContentId());
    document.setDescription(mongoDocument.getDescription());
    return document;
  }
}
