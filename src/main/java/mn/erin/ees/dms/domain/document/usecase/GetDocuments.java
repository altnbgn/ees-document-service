package mn.erin.ees.dms.domain.document.usecase;

import java.util.List;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;

public class GetDocuments
{
  private DocumentRepository documentRepository;

  public GetDocuments(DocumentRepository documentRepository)
  {
    this.documentRepository=documentRepository;
  }
  public List<Document> execute(String organizationId, String groupId)
  {
    try
    {
      return documentRepository.get(organizationId,groupId);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
