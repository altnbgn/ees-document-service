package mn.erin.ees.dms.domain.document_type.usecase;

import java.util.List;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;

public interface DocumentTypeRepository
{
  DocumentType createDocumentType(String organizationId,
      String groupId,
      String name,
      String category,
      String description);

  DocumentType getDocumentTypeById(String id);

  boolean hasDocumentTypeWithName(String name);

  List<DocumentType> getDocumentTypes(String groupId, String organizationId);
}
