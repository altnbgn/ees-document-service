package mn.erin.ees.dms.domain.document_type.usecase;

import org.apache.commons.lang3.StringUtils;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.model.DocumentTypeInput;
import mn.erin.ees.dms.utilities.CreateDocumentTypeException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class CreateDocumentType
{
  private DocumentTypeRepository documentTypeRepository;

  public CreateDocumentType(DocumentTypeRepository documentTypeRepository)
  {
    this.documentTypeRepository = documentTypeRepository;
  }

  public DocumentType execute(DocumentTypeInput input) throws CreateDocumentTypeException
  {
    if (StringUtils.isBlank(input.getOrganizationID()))
    {
      throw new CreateDocumentTypeException(ExceptionReason.INPUT_INVALID, "Organization ID is missing!");
    }
    if (StringUtils.isBlank(input.getGroupID()))
    {
      throw new CreateDocumentTypeException(ExceptionReason.INPUT_INVALID, "Group ID is missing!");
    }
    if (StringUtils.isBlank(input.getCategory()))
    {
      throw new CreateDocumentTypeException(ExceptionReason.INPUT_INVALID, "Category is missing!");
    }
    if (StringUtils.isBlank(input.getName()))
    {
      throw new CreateDocumentTypeException(ExceptionReason.INPUT_INVALID, "Name is missing!");
    }
    String name = input.getName().trim();
    if (documentTypeRepository.hasDocumentTypeWithName(name))
    {
      throw new CreateDocumentTypeException(ExceptionReason.DUPLICATE, "Duplicate document type " + name);
    }

    return documentTypeRepository.createDocumentType(input.getOrganizationID(),
        input.getGroupID(),
        name,
        input.getCategory(),
        input.getDescription());
  }
}

