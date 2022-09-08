package mn.erin.ees.dms.domain.document.usecase;

import mn.erin.ees.dms.domain.document.api.DocumentOutput;
import mn.erin.ees.dms.domain.document.model.Document;

/**
 * @author Altanbagana
 */
public class ConvertToDocumentOutput
{
  public DocumentOutput convertToDocumentOutput(Document document)
  {
    return new DocumentOutput(
        document.getDocumentName(),
        document.getDocumentType(),
        document.getContentId()
    );
  }
}
