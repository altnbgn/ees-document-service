package mn.erin.ees.dms.domain.document.usecase;

import org.springframework.core.io.Resource;

import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class DownloadDocument
{
  private final DocumentRepository documentRepository;

  public DownloadDocument(DocumentRepository documentRepository)
  {
    this.documentRepository = documentRepository;
  }

  public Resource execute(String contentId) throws DocumentCreationException
  {
    Resource resource;

    try
    {
      resource = documentRepository.downloadByContentId(contentId);
    }
    catch (Exception e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, e.getMessage());
    }

    return resource;
  }
}
