package mn.erin.ees.dms.domain.document.usecase;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
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

  public Document execute(DocumentInput input) throws DocumentCreationException
  {
    if (StringUtils.isBlank(input.getOrganizationId()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document organizationID is missing");
    }
    if (StringUtils.isBlank(input.getGroupId()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document groupId is missing");
    }
    if (StringUtils.isBlank(input.getDocumentName()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document documentName is missing");
    }
    if (StringUtils.isBlank(input.getCreatedUser()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document createdUser is missing");
    }
    if (StringUtils.isBlank(input.getDocumentType()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document documentType is missing");
    }
    if (StringUtils.isBlank(input.getDescription()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document description is missing");
    }

    DocumentType documentType = documentTypeRepository.getDocumentTypeById(input.getDocumentType());
    if (documentType == null)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_FOUND, "Document type not found " + input.getDocumentType());
    }

    try
    {
      return documentRepository.fileSave(input, documentType);
    }

    catch (IOException e)
    {
      throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not saved (IOException when saving)");
    }
  }
}
