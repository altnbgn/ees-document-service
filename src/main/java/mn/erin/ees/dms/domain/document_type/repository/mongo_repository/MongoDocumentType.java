package mn.erin.ees.dms.domain.document_type.repository.mongo_repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MongoDocumentType
{
  @Id
  private String id;
  @Indexed
  private final String createdBy;
  @Indexed
  private String organizationId;
  @Indexed
  private String groupId;
  @Indexed
  private String category;
  @Indexed
  private String name;
  private String description;

  public MongoDocumentType(String id, String createdBy, String organizationId, String groupId, String category, String name)
  {
    this.id = id;
    this.createdBy = createdBy;
    this.organizationId = organizationId;
    this.groupId = groupId;
    this.category = category;
    this.name = name;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getCreatedBy()
  {
    return createdBy;
  }

  public String getOrganizationId()
  {
    return organizationId;
  }

  public void setOrganizationId(String organizationId)
  {
    this.organizationId = organizationId;
  }

  public String getGroupId()
  {
    return groupId;
  }

  public void setGroupId(String groupId)
  {
    this.groupId = groupId;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
