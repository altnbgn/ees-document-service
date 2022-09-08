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
  private String documentType;
  private String contentId;
  private String createdUser;
  private LocalDate createdDate;
  private String description;
  private String referrerId;
  private Resource resource;

  public Document(String id, String documentName, String organizationId, String groupId, String createdUser, String documentType,
      LocalDate date, String referrerId, String description, Resource resource)
  {
    this.id = id;
    this.documentName = Validate.notBlank(documentName);
    this.organizationId = Validate.notBlank(organizationId);
    this.groupId = Validate.notBlank(groupId);
    this.documentType = Validate.notBlank(documentType);
    this.createdUser = Validate.notBlank(createdUser);
    this.createdDate = Validate.notNull(date);
    this.referrerId = Validate.notBlank(referrerId);
    this.description = description;
    this.resource = resource;
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

  public void setDocumentType(String documentType)
  {
    this.documentType = documentType;
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

  public String getDocumentType()
  {
    return documentType;
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

  public String getReferrerId()
  {
    return referrerId;
  }

  public void setReferrerId(String referrerId)
  {
    this.referrerId = referrerId;
  }

  public void setCreatedDate(LocalDate createdDate)
  {
    this.createdDate = createdDate;
  }

  public Resource getResource()
  {
    return resource;
  }

  public void setFileResource(Resource fileBytes)
  {
    this.resource = fileBytes;
  }

  public String getContentId()
  {
    return contentId;
  }

  public void setContentId(String contentId)
  {
    this.contentId = contentId;
  }

  public void setResource(Resource resource)
  {
    this.resource = resource;
  }
}
