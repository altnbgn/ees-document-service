package mn.erin.ees.dms.domain.document.usecase;

import mn.erin.ees.dms.domain.document.api.DocumentOutput;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;

public class GetDocument
{
  private DocumentRepository documentRepository;

  public GetDocument(DocumentRepository documentRepository)
  {
    this.documentRepository = documentRepository;
  }

  public DocumentOutput execute(String journalEntryId, String name)
  {
    Document document;
    try
    {
      document = documentRepository.findByReferrerIdAndName(journalEntryId, name);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
    return new DocumentOutput(document.getDocumentName(), document.getDocumentType(), document.getContentId());
  }
}
