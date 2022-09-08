package mn.erin.ees.dms.domain.document_type.model;

public class DocumentType
{
  private final String id;
  private final String createdBy;
  private final String category;
  private final String name;
  private final String description;

  public DocumentType(String id, String createdBy, String category, String name, String description)
  {
    this.id = id;
    this.createdBy = createdBy;
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