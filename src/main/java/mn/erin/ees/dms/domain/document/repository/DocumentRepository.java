package mn.erin.ees.dms.domain.document.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.utilities.DocumentCreationException;

public interface DocumentRepository
{
  String fileSave(DocumentInput input, DocumentType documentType) throws DocumentCreationException, IOException;

  List<Document> get(String organizationId, String groupId);

  Resource fileDownload(String contentId) throws DocumentCreationException;

  public void deleteById(String contentId);
}
