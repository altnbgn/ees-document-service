package mn.erin.ees.dms.domain.document.repository;

import java.io.IOException;
import java.util.List;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;

public interface DocumentRepository
{
  Document fileSave(DocumentInput input, DocumentType documentType) throws IOException;
  List<Document> get(String organizationId, String groupId);
}
