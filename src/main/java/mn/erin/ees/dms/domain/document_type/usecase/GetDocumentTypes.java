package mn.erin.ees.dms.domain.document_type.usecase;

import java.util.List;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;

public class GetDocumentTypes
{
  private final DocumentTypeRepository documentTypeRepository;

  public GetDocumentTypes(DocumentTypeRepository documentTypeRepository)
  {
    this.documentTypeRepository = documentTypeRepository;
  }

  public List<DocumentType> execute(String organizationId, String groupId) throws Exception
  {
    try
    {
      return documentTypeRepository.getDocumentTypes(organizationId, groupId);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
