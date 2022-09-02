package mn.erin.ees.dms.domain.document.usecase;

import org.springframework.core.io.Resource;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentMetaRepository;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class DownloadDocument
{
  private final DocumentRepository documentRepository;
  private final DocumentMetaRepository documentMetaRepository;

  public DownloadDocument(DocumentRepository documentDownloadDeleteRepository, DocumentMetaRepository documentMetaRepository)
  {
    this.documentRepository = documentDownloadDeleteRepository;
    this.documentMetaRepository = documentMetaRepository;
  }

  public Document execute(String contentId) throws DocumentCreationException
  {
    Resource resource;
    Document document = documentMetaRepository.findByContentId(contentId);
    if(null == document)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, "Can not find document");
    }

    try
    {
      resource = documentRepository.fileDownload(contentId);
    }
    catch (Exception e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, e.getMessage());
    }

    document.setFileResource(resource);
    return  document;
  }
}
