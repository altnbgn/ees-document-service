package mn.erin.ees.dms.domain.document;

import org.apache.commons.lang3.StringUtils;

import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.ExceptionReason;

/**
 * @author Altanbagana
 */
public class CreateDocumentValidation
{
  public void validate(DocumentInput input) throws DocumentCreationException
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
    if (StringUtils.isBlank(input.getDocumentTypeId()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document documentType is missing");
    }
    if (StringUtils.isBlank(input.getDescription()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document description is missing");
    }
  }
}
