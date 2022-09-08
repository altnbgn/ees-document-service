package mn.erin.ees.dms.domain.document.usecase;

import java.io.IOException;

import mn.erin.ees.dms.domain.document.CreateDocumentValidation;
import mn.erin.ees.dms.domain.document.api.DocumentInput;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class CreateDocument
{
  private final DocumentRepository documentRepository;
  private final DocumentTypeRepository documentTypeRepository;

  public CreateDocument(DocumentRepository documentRepository, DocumentTypeRepository documentTypeRepository)
  {
    this.documentRepository = documentRepository;
    this.documentTypeRepository = documentTypeRepository;
  }

  public String execute(DocumentInput input) throws DocumentCreationException
  {
    new CreateDocumentValidation().validate(input);
    //    DocumentType documentType = documentTypeRepository.getDocumentTypeById(input.getDocumentTypeId());
    //    if (documentType == null)
    //    {
    //      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, "Document type not found " + input.getDocumentTypeId());
    //    }

    try
    {
      return documentRepository.upload(new Document(null, input.getDocumentName(), input.getOrganizationId(), input.getGroupId(),
          input.getCreatedUser(), input.getDocumentTypeId(), input.getCreatedDate(), input.getJournalEntryId(), input.getDescription(), input.getFile().getResource()));
    }
    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not saved (IOException when saving)");
    }
  }
}
