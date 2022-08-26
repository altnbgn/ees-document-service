package mn.erin.ees.dms.domain.document.usecase;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.MongoDocument;
import mn.erin.ees.dms.utilities.DocumentCreationException;

public interface DocumentRepository
{
  String fileSave(MultipartFile file) throws IOException;
  List<Document> get(String organizationId, String groupId);
  Document save(String organizationId, String groupId, String documentName, String name, String createdUser,
      LocalDate createdDate, String description, String originalFilename, String contentId);
}
