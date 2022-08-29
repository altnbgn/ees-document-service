package mn.erin.ees.dms.domain.document_type.repository.mongo_repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;

@Repository
public class DocumentTypeRepositorylmpl implements DocumentTypeRepository
{
  private final MongoDocumentTypeRepository mongoDocumentTypeRepository;

  public DocumentTypeRepositorylmpl(MongoDocumentTypeRepository mongoDocumentTypeRepository)
  {
    this.mongoDocumentTypeRepository = mongoDocumentTypeRepository;
  }

  @Override
  public DocumentType createDocumentType(String organizationId,
      String groupId,
      String name,
      String category,
      String description)
  {
    MongoDocumentType mongoDocumentType = new MongoDocumentType(null, "", organizationId, groupId, category, name);
    mongoDocumentType.setDescription(description);
    return mapper(mongoDocumentTypeRepository.save(mongoDocumentType));
  }

  @Override
  public DocumentType getDocumentTypeById(String id)
  {
    Optional<MongoDocumentType> output = mongoDocumentTypeRepository.findById(id);
    return output.map(this::mapper).orElse(null);
  }

  @Override
  public boolean hasDocumentTypeWithName(String name)
  {
    return mongoDocumentTypeRepository.findFirstByNameEqualsIgnoreCase(name).isPresent();
  }

  @Override
  public List<DocumentType> getDocumentTypes(String organizationId, String groupId)
  {
    Iterable<MongoDocumentType> mongoDocumentTypes = mongoDocumentTypeRepository.findAllByGroupIdAndOrganizationId(groupId, organizationId);

    List<DocumentType> documentTypeList = new ArrayList<>();

    mongoDocumentTypes.forEach(mongoDocumentType -> documentTypeList.add(mapper(mongoDocumentType)));

    return documentTypeList;
  }

  private DocumentType mapper(MongoDocumentType mongoDocumentType)
  {
    return new DocumentType(mongoDocumentType.getId(),
        mongoDocumentType.getCreatedBy(),
        mongoDocumentType.getOrganizationId(),
        mongoDocumentType.getGroupId(),
        mongoDocumentType.getCategory(),
        mongoDocumentType.getName(),
        mongoDocumentType.getDescription()
    );
  }
}
