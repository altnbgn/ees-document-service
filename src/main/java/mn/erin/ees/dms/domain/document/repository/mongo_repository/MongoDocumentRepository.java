package mn.erin.ees.dms.domain.document.repository.mongo_repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDocumentRepository extends MongoRepository<MongoDocument, String>
{
  Iterable<MongoDocument> findAllByOrganizationIdAndGroupId(String organizationId, String groupId);
}