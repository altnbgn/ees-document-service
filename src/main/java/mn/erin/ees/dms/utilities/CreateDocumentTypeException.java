package mn.erin.ees.dms.utilities;

import mn.erin.ees.dms.utilities.DmsException;
import mn.erin.ees.dms.utilities.ExceptionReason;

public class CreateDocumentTypeException extends DmsException
{
  public CreateDocumentTypeException(ExceptionReason reason, String message)
  {
    super(reason, message);
  }
}
