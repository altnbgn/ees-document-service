package mn.erin.ees.dms.domain.document.api;

/**
 * @author Altanbagana
 */
public class DocumentOutput
{
  private final String name;
  private final String contentTypeId;
  private final String contentId;

  public DocumentOutput(String name, String contentTypeId, String contentId)
  {
    this.name = name;
    this.contentTypeId = contentTypeId;
    this.contentId = contentId;
  }

  public String getName()
  {
    return name;
  }

  public String getContentTypeId()
  {
    return contentTypeId;
  }

  public String getContentId()
  {
    return contentId;
  }
}
