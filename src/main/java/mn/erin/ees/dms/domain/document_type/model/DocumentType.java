package mn.erin.ees.dms.domain.document_type.model;

public class DocumentType
{
  private final String id;
  private final String createdBy;
  private final String organizationId;
  private final String groupId;
  private final String category;
  private final String name;
  private final String description;

  public DocumentType(String id, String createdBy, String organizationID, String groupID, String category, String name, String description)
  {
    this.id = id;
    this.createdBy = createdBy;
    this.organizationId = organizationID;
    this.groupId = groupID;
    this.category = category;
    this.name = name;
    this.description = description;
  }

  public String getId()
  {
    return id;
  }

  public String getCreatedBy()
  {
    return createdBy;
  }

  public String getOrganizationId()
  {
    return organizationId;
  }

  public String getGroupId()
  {
    return groupId;
  }

  public String getCategory()
  {
    return category;
  }

  public String getName()
  {
    return name;
  }

  public String getDescription()
  {
    return description;
  }
}