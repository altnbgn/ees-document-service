package mn.erin.ees.dms.domain.document.usecase;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsResource;

public interface DocumentDownloadDeleteRepository
{
  void deleteById(String contentId);
  GridFsResource fileDownload(String contentId);

}
