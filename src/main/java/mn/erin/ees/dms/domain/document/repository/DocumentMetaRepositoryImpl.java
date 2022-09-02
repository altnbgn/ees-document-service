package mn.erin.ees.dms.domain.document.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;

/**
 * @author Altanbagana
 */
@Repository
public class DocumentMetaRepositoryImpl implements DocumentMetaRepository
{
  private final MongoDocumentRepository mongoDocumentRepository;

  public DocumentMetaRepositoryImpl(MongoDocumentRepository mongoDocumentRepository)
  {
    this.mongoDocumentRepository = mongoDocumentRepository;
  }

  @Override
  public String save(String contentId, DocumentInput input, DocumentType documentType)
  {
    MongoDocument mongoDocument = new MongoDocument(
        input.getOrganizationId(),
        input.getGroupId(),
        documentType.getName(),
        input.getDocumentTypeId(),
        input.getCreatedUser(),
        input.getCreatedDate(),
        input.getDescription(),
        input.getFile().getName(),
        contentId);
    mongoDocumentRepository.save(mongoDocument);
    return contentId;
  }

  @Override
  public Document findByContentId(String contentId)
  {
    Optional<MongoDocument> mongoDocument = mongoDocumentRepository.findByContentId(contentId);
    return mongoDocument.map(this::mapToDocument).orElse(null);
  }

  private Document mapToDocument(MongoDocument mongoDocument)
  {
    return new Document(
        mongoDocument.getId(),
        mongoDocument.getOrganizationId(),
        mongoDocument.getGroupId(),
        mongoDocument.getDocumentName(),
        mongoDocument.getCreatedBy(),
        mongoDocument.getDocumentType(),
        mongoDocument.getDate(),
        mongoDocument.getFileName(),
        mongoDocument.getContentId());
  }
}
