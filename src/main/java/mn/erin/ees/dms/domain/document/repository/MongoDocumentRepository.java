//package mn.erin.ees.dms.domain.document.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import mn.erin.ees.dms.domain.document.repository.MongoDocument;
//
//public interface MongoDocumentRepository extends MongoRepository<MongoDocument, String>
//{
//  Optional<MongoDocument> findAllByJournalEntryId(String journalEntryId);
//  Optional<MongoDocument> findByContentId(String contentId);
//}