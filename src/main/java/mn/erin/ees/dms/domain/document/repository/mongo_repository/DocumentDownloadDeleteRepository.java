package mn.erin.ees.dms.domain.document.repository.mongo_repository;

import org.springframework.data.mongodb.gridfs.GridFsResource;

public interface DocumentDownloadDeleteRepository
{
  void deleteById(String contentId);
  //TODO: create Model instead of GridFsResource
  GridFsResource fileDownload(String contentId);

}
