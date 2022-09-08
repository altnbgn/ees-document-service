//package mn.erin.ees.dms.domain.document_type.repository.mongo_repository;
//
//import java.util.Optional;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//public interface MongoDocumentTypeRepository extends MongoRepository<MongoDocumentType, String>
//{
//  Optional<MongoDocumentType> findFirstByNameEqualsIgnoreCase(String name);
//
//  Iterable<MongoDocumentType> findAllByGroupIdAndOrganizationId(String groupId, String organizationId);
//}
