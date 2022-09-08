package mn.erin.ees.dms.domain.document.usecase;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;

import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentGettingException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class DownloadDocument
{
  private final DocumentRepository documentRepository;

  public DownloadDocument(DocumentRepository documentRepository)
  {
    this.documentRepository = documentRepository;
  }

  public Resource execute(String contentId) throws DocumentGettingException
  {
    if (StringUtils.isBlank(contentId))
    {
      throw new DocumentGettingException(ExceptionReason.INPUT_INVALID, "content id required!");
    }
    return documentRepository.downloadByContentId(contentId);
  }
}
