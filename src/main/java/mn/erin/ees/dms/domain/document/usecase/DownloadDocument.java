package mn.erin.ees.dms.domain.document.usecase;

import org.springframework.data.mongodb.gridfs.GridFsResource;

import mn.erin.ees.dms.domain.document.repository.mongo_repository.DocumentDownloadDeleteRepository;

public class DownloadDocument
{
  private DocumentDownloadDeleteRepository documentDownloadDeleteRepository;

  public DownloadDocument(DocumentDownloadDeleteRepository documentDownloadDeleteRepository)
  {
    this.documentDownloadDeleteRepository = documentDownloadDeleteRepository;
  }
  public GridFsResource execute(String contentId)
  {
      try
      {
        return documentDownloadDeleteRepository.fileDownload(contentId);
      }
      catch (Exception e)
      {
        throw new RuntimeException(e);
      }
  }
}
