package mn.erin.ees.dms.domain.document.model;

import java.time.LocalDate;

import org.apache.commons.lang3.Validate;
import org.springframework.core.io.Resource;

public class Document
{
  private String id;
  private String organizationId;
  private String groupId;
  private String documentName;
  private String type;
  private String createdUser;
  private LocalDate createdDate;
  private String fileName;
  private String contentId;
  private String description;
  private Resource fileResource;

  public Document(String id, String organizationId, String groupId, String documentName, String createdUser, String documentType,
      LocalDate date, String fileName, String contentId)
  {
    this.id = Validate.notBlank(id);
    this.organizationId = Validate.notBlank(organizationId);
    this.groupId = Validate.notBlank(groupId);
    this.documentName = Validate.notBlank(documentName);
    this.type = Validate.notBlank(documentType);
    this.createdUser = Validate.notBlank(createdUser);
    this.fileName = Validate.notBlank(fileName);
    this.contentId = Validate.notBlank(contentId);
    this.createdDate = Validate.notNull(date);
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

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }

  public void setContentId(String contentId)
  {
    this.contentId = contentId;
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

  public String getFileName()
  {
    return fileName;
  }

  public String getContentId()
  {
    return contentId;
  }

  public void setCreatedDate(LocalDate createdDate)
  {
    this.createdDate = createdDate;
  }

  public Resource getFileResource()
  {
    return fileResource;
  }

  public void setFileResource(Resource fileResource)
  {
    this.fileResource = fileResource;
  }
}
