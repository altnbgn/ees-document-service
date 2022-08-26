package mn.erin.ees.dms.domain.document.model;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class DocumentInput
{
  private String organizationId;
  private String groupId;
  private String documentName;
  private String createdUser;

  private String documentType;
  private LocalDate createdDate;

  private String description;

  private MultipartFile file;

  public DocumentInput(String organizationId, String groupId, String documentName, String createdUser, String documentType, LocalDate createdDate,
      String description, MultipartFile file)
  {
    this.organizationId = organizationId;
    this.groupId = groupId;
    this.documentName = documentName;
    this.createdUser = createdUser;
    this.documentType = documentType;
    this.createdDate = createdDate;
    this.description = description;
    this.file = file;
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

  public String getDocumentName()
  {
    return documentName;
  }

  public void setDocumentName(String documentName)
  {
    this.documentName = documentName;
  }

  public String getCreatedUser()
  {
    return createdUser;
  }

  public void setCreatedUser(String createdUser)
  {
    this.createdUser = createdUser;
  }

  public String getDocumentType()
  {
    return documentType;
  }

  public void setDocumentType(String documentType)
  {
    this.documentType = documentType;
  }

  public LocalDate getCreatedDate()
  {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate)
  {
    this.createdDate = createdDate;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public MultipartFile getFile()
  {
    return file;
  }

  public void setFile(MultipartFile file)
  {
    this.file = file;
  }
}