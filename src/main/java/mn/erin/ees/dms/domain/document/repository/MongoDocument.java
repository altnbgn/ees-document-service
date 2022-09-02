package mn.erin.ees.dms.domain.document.repository;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MongoDocument
{
  @Id
  private String id;
  @Indexed
  private final String organizationId;
  @Indexed
  private final String groupId;
  @Indexed
  private String documentName;
  @Indexed
  private String documentType;
  @Indexed
  private String createdUser;
  @Indexed
  private LocalDate date;
  @Indexed
  private String description;
  @Indexed
  private String fileName;
  @Indexed
  private String contentId;

  public MongoDocument(String organizationId, String groupId, String documentName, String documentType, String createdUser,
      LocalDate date, String description, String fileName, String contentId)
  {
    this.organizationId = organizationId;
    this.groupId = groupId;
    this.documentName = documentName;
    this.documentType = documentType;
    this.createdUser = createdUser;
    this.date = date;
    this.description = description;
    this.fileName = fileName;
    this.contentId = contentId;
  }

  public String getContentId()
  {
    return contentId;
  }

  public void setContentId(String contentId)
  {
    this.contentId = contentId;
  }

  public String getId()
  {
    return contentId;
  }

  public void setId(String contentId)
  {
    this.contentId = contentId;
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

  public void setDocumentName(String documentName)
  {
    this.documentName = documentName;
  }

  public String getDocumentType()
  {
    return documentType;
  }

  public void setDocumentType(String documentType)
  {
    this.documentType = documentType;
  }

  public String getCreatedBy()
  {
    return createdUser;
  }

  public void setCreatedUser(String createdBy)
  {
    this.createdUser = createdBy;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public void setDate(LocalDate date)
  {
    this.date = date;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getFileName()
  {
    return fileName;
  }

  public void setFileName(String fileName)
  {
    this.fileName = fileName;
  }
}

