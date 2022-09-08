//package mn.erin.ees.dms.domain.document.repository.mongo_repository;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import com.mongodb.client.gridfs.model.GridFSFile;
//import org.springframework.core.io.Resource;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.gridfs.GridFsTemplate;
//
//import mn.erin.ees.dms.domain.document.model.Document;
//import mn.erin.ees.dms.domain.document.model.DocumentInput;
//import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
//import mn.erin.ees.dms.domain.document.repository.MongoDocument;
//import mn.erin.ees.dms.domain.document.repository.MongoDocumentRepository;
//import mn.erin.ees.dms.domain.document_type.model.DocumentType;
//
//import static org.springframework.data.mongodb.core.query.Criteria.where;
//
////@Primary
////@Repository
//public class DocumentRepositoryMongoGridFSImpl implements DocumentRepository
//{
//  private MongoDocumentRepository mongoDocumentRepository;
//  private GridFsTemplate gridFsTemplate;
//
//  public DocumentRepositoryMongoGridFSImpl(MongoDocumentRepository mongoDocumentRepository, GridFsTemplate gridFsTemplate)
//  {
//    this.mongoDocumentRepository = mongoDocumentRepository;
//    this.gridFsTemplate = gridFsTemplate;
//  }
//
//  @Override
//  public void deleteById(String contentId)
//  {
//    gridFsTemplate.delete(Query.query(where("_id").is(contentId)));
//  }
//
//  @Override
//  public String upload(Document document) throws IOException
//  {
//    if (null == document.getFile() || null == document.getFile().getOriginalFilename())
//    {
//      return null;
//    }
//    return gridFsTemplate.store(document.getFile().getInputStream(), document.getFile().getOriginalFilename()).toString();
//  }
//
//  @Override
//  public Resource downloadByContentId(String contentId)
//  {
//    GridFSFile file = gridFsTemplate.findOne(Query.query(where("_id").is(contentId)));
//    assert file != null;
//    return gridFsTemplate.getResource(file);
//  }
//
//  @Override
//  public List<Document> downloadByJournalEntryId(String journalEntryId)
//  {
//    Optional<MongoDocument> mongoDocumentList = mongoDocumentRepository.findAllByJournalEntryId(journalEntryId);
//    return mongoDocumentList.stream().map(this::mapper).collect(Collectors.toList());
//  }
//
//  public Document mapper(MongoDocument mongoDocument)
//  {
//    Document document = new Document(mongoDocument.getId(),
//        mongoDocument.getOrganizationId(),
//        mongoDocument.getGroupId(),
//        mongoDocument.getDocumentName(),
//        mongoDocument.getDocumentType(),
//        mongoDocument.getCreatedBy(),
//        mongoDocument.getDate(),
//        mongoDocument.getFileName(),
//        mongoDocument.getJournalEntryId(),
//        mongoDocument.getContentId());
//    document.setDescription(mongoDocument.getDescription());
//    return document;
//  }
//}
