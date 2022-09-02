package mn.erin.ees.dms.domain.document.usecase;

import java.io.IOException;

import mn.erin.ees.dms.domain.document.CreateDocumentValidation;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document.repository.DocumentMetaRepositoryImpl;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class CreateDocument
{
  private final DocumentRepository documentRepository;
  private final DocumentTypeRepository documentTypeRepository;
  private final DocumentMetaRepositoryImpl documentMetaRepositoryImpl;

  public CreateDocument(DocumentRepository documentRepository, DocumentTypeRepository documentTypeRepository, DocumentMetaRepositoryImpl documentMetaRepositoryImpl)
  {
    this.documentRepository = documentRepository;
    this.documentTypeRepository = documentTypeRepository;
    this.documentMetaRepositoryImpl = documentMetaRepositoryImpl;
  }

  public String execute(DocumentInput input) throws DocumentCreationException
  {
    new CreateDocumentValidation().validate(input);
    DocumentType documentType = documentTypeRepository.getDocumentTypeById(input.getDocumentTypeId());
    if (documentType == null)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, "Document type not found " + input.getDocumentTypeId());
    }

    try
    {
      String contentId = documentRepository.fileSave(input, documentType);
      if (null == contentId)
      {
        throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not saved (file or file name found!)");
      }
      return documentMetaRepositoryImpl.save(contentId, input, documentType);
    }

    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not saved (IOException when saving)");
    }
  }
}
