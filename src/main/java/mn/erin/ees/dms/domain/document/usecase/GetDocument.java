package mn.erin.ees.dms.domain.document.usecase;

import org.apache.commons.lang3.StringUtils;

import mn.erin.ees.dms.domain.document.api.DocumentOutput;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentGettingException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class GetDocument
{
  private DocumentRepository documentRepository;

  public GetDocument(DocumentRepository documentRepository)
  {
    this.documentRepository = documentRepository;
  }

  public DocumentOutput execute(String referrerId, String name) throws DocumentGettingException
  {
    if (StringUtils.isBlank(referrerId))
    {
      throw new DocumentGettingException(ExceptionReason.INPUT_INVALID, "referred id is invalid");
    }

    if (StringUtils.isBlank(referrerId))
    {
      throw new DocumentGettingException(ExceptionReason.INPUT_INVALID, "name is invalid");
    }

    return new ConvertToDocumentOutput().convertToDocumentOutput(documentRepository.findByReferrerIdAndName(referrerId, name));
  }
}
