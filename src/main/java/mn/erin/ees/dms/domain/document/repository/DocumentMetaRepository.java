package mn.erin.ees.dms.domain.document.repository;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;

/**
 * @author Altanbagana
 */
public interface DocumentMetaRepository
{
  public String save(String contentId, DocumentInput input, DocumentType documentType);
  public Document findByContentId(String documentId);
}
