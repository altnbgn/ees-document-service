package mn.erin.ees.dms.domain.document_type.model;

public class DocumentTypeInput
{
  private final String organizationId;
  private final String groupId;
  private final String name;
  private final String category;
  private final String description;

  public DocumentTypeInput(String organizationId, String groupId, String name, String category, String description)
  {
    this.organizationId = organizationId;
    this.groupId = groupId;
    this.name = name;
    this.category = category;
    this.description = description;
  }

  public String getOrganizationId()
  {
    return organizationId;
  }

  public String getGroupId()
  {
    return groupId;
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
