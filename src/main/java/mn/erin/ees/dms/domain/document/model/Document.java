package mn.erin.ees.dms.domain.document.model;

import java.time.LocalDate;

public class Document
{
  private String id;
  private String organizationId;
  private String groupId;
  private String documentName;
  private String type;
  private String createdUser;
  private LocalDate createdDate;
  private String description;
  private String file;
  private String path;

  public Document(String id, String organizationId, String groupId, String documentName, String createdUser,String documentType,
      LocalDate date, String file, String path)
  {
    this.id = id;
    this.organizationId = organizationId;
    this.groupId = groupId;
    this.documentName = documentName;
    this.type = documentType;
    this.createdUser = createdUser;
    this.file = file;
    this.path = path;
    this.createdDate = date;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public void setOrganizationId(String organizationId)
  {
    this.organizationId = organizationId;
  }

  public void setGroupId(String groupId)
  {
    this.groupId = groupId;
  }

  public void setDocumentName(String documentName)
  {
    this.documentName = documentName;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public void setCreatedUser(String createdUser)
  {
    this.createdUser = this.createdUser;
  }

  public void setDate(LocalDate date)
  {
    this.createdDate = date;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void setFile(String file)
  {
    this.file = file;
  }

  public void setPath(String path)
  {
    this.path = path;
  }

  public String getId()
  {
    return id;
  }

  public String getOrganizationId()
  {
    return organizationId;
  }

  public String getGroupId()
  {
    return groupId;
  }

  public String getDocumentName()
  {
    return documentName;
  }

  public String getType()
  {
    return type;
  }

  public String getCreatedUser()
  {
    return createdUser;
  }

  public LocalDate getCreatedDate()
  {
    return createdDate;
  }

  public String getDescription()
  {
    return description;
  }

  public String getFile()
  {
    return file;
  }

  public String getPath()
  {
    return path;
  }
}
