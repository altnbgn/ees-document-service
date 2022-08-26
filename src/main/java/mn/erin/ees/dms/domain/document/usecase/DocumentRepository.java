package mn.erin.ees.dms.domain.document.usecase;

import java.util.List;

import org.bson.types.ObjectId;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.utilities.DocumentCreationException;

public interface DocumentRepository
{
  void deleteById(ObjectId contentId);

  List<Document> get(String organizationId, String groupId);

  Document save(DocumentInput input) throws DocumentCreationException;
}
