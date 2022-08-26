package mn.erin.ees.dms.domain.document_type.model;

public class DocumentTypeInput
{
  private final String organizationID;
  private final String groupID;
  private final String name;
  private final String category;
  private final String description;

  public DocumentTypeInput(String organizationID, String groupID, String name, String category, String description)
  {
    this.organizationID = organizationID;
    this.groupID = groupID;
    this.name = name;
    this.category = category;
    this.description = description;
  }

  public String getOrganizationID()
  {
    return organizationID;
  }

  public String getGroupID()
  {
    return groupID;
  }

  public String getName()
  {
    return name;
  }

  public String getCategory()
  {
    return category;
  }

  public String getDescription()
  {
    return description;
  }
}
