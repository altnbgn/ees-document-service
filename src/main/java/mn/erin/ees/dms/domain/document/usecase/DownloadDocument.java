package mn.erin.ees.dms.domain.document.usecase;

import java.util.stream.Stream;

import org.springframework.data.mongodb.gridfs.GridFsResource;

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
