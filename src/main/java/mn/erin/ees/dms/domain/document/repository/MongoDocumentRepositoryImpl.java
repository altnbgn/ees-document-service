package mn.erin.ees.dms.domain.document.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.usecase.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

@Repository
@Component
public class MongoDocumentRepositoryImpl implements DocumentRepository
{
  private final MongoDocumentRepository mongoDocumentRepository;
  @Lazy
  @Autowired
  private GridFsTemplate gridFsTemplate;

  public MongoDocumentRepositoryImpl(MongoDocumentRepository mongoDocumentRepository)
  {
    this.mongoDocumentRepository = mongoDocumentRepository;
  }

  @Override
  public Document save(DocumentInput input) throws DocumentCreationException
  {
    ObjectId contentId;
    MongoDocument mongoDocument;
    try
    {
      if(null == input.getFile().getOriginalFilename() || null == input.getFile().getInputStream())
      {
        return null;
      }
      contentId = gridFsTemplate.store(input.getFile().getInputStream(), input.getFile().getOriginalFilename());

    if (StringUtils.isBlank(contentId.toString()))
    {
      deleteById(contentId);
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not save file " + input.getFile().getOriginalFilename());
    }
    mongoDocument = new MongoDocument(
        input.getOrganizationId(),
        input.getGroupId(),
        input.getDocumentName(),
        input.getDocumentType(),
        input.getCreatedUser(),
        input.getCreatedDate(),
        input.getDescription(),
        input.getFile().getOriginalFilename(),
        contentId.toString());
    mongoDocument = mongoDocumentRepository.save(mongoDocument);

    }
    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not save file" + input.getFile().getOriginalFilename());
    }

    if(null == mongoDocument)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not save file " + input.getFile().getOriginalFilename());
    }
    return mapper(mongoDocument);
  }

  @Override
  public void deleteById(ObjectId contentId)
  {
    gridFsTemplate.delete(Query.query(Criteria.where(contentId.toString()).is(contentId)));
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

  public Document mapper( MongoDocument mongoDocument)
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
