package mn.erin.ees.dms.domain.document.usecase;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import mn.erin.ees.dms.utilities.ExceptionReason;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.usecase.DocumentTypeRepository;

public class CreateDocument
{
  private final DocumentRepository documentRepository;
  private final DocumentDownloadDeleteRepository documentDownloadDeleteRepository;
  private final DocumentTypeRepository documentTypeRepository;
  private GridFsTemplate gridFsTemplate;

  public CreateDocument(DocumentRepository documentRepository, DocumentTypeRepository documentTypeRepository,GridFsTemplate gridFsTemplate, DocumentDownloadDeleteRepository documentDownloadDeleteRepository)
  {
    this.documentRepository = documentRepository;
    this.documentTypeRepository=documentTypeRepository;
    this.gridFsTemplate = gridFsTemplate;
    this.documentDownloadDeleteRepository=documentDownloadDeleteRepository;
  }

  public Document execute(DocumentInput input) throws DocumentCreationException, IOException
  {
    if (StringUtils.isBlank(input.getOrganizationId()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document organizationID is missing");
    }
    if (StringUtils.isBlank(input.getGroupId()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document groupId is missing");
    }
    if (StringUtils.isBlank(input.getDocumentName()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document documentName is missing");
    }
    if (StringUtils.isBlank(input.getCreatedUser()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document createdUser is missing");
    }
    if (StringUtils.isBlank(input.getDocumentType()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document documentType is missing");
    }
    if (StringUtils.isBlank(input.getDescription()))
    {
      throw new DocumentCreationException(ExceptionReason.INPUT_INVALID, "Document description is missing");
    }

    try
    {
      DocumentType documentType = documentTypeRepository.getDocumentTypeById(input.getDocumentType());
      if (documentType == null)
      {
        throw new DocumentCreationException(ExceptionReason.NOT_FOUND, "Document type not found " + input.getDocumentType());
      }
      String contentId = documentRepository.fileSave(input.getFile());
      if (StringUtils.isBlank(contentId))
      {
        throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not save file " + input.getFile().getOriginalFilename());
      }
      Document document = documentRepository.save( input.getOrganizationId(),
          input.getGroupId(),
          input.getDocumentName(),
          documentType.getName(),
          input.getCreatedUser(),
          input.getCreatedDate(),
          input.getDescription(),
          input.getFile().getOriginalFilename(),
          contentId);
      if (document==null)
      {
        documentDownloadDeleteRepository.deleteById(contentId);
        throw new DocumentCreationException(ExceptionReason.NOT_SAVE_FILE, "Document not save document " + input.getFile().getOriginalFilename());
      }
      return document;
    }
    catch (IOException e)
    {
      throw new IllegalStateException(e);
    }
  }
}
