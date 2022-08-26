package mn.erin.ees.dms.utilities;

public abstract class DmsException extends Exception
{
  public final ExceptionReason reason;
  protected DmsException(ExceptionReason reason, String message)
  {
    super(message);
    this.reason = reason;
  }
}
