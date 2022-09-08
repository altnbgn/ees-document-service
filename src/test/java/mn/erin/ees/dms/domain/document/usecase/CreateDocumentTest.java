package mn.erin.ees.dms.domain.document.usecase;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.api.DocumentInput;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;

/**
 * @author Altanbagana
 */
class CreateDocumentTest
{
  DocumentRepository documentRepository = Mockito.mock(DocumentRepository.class);
  DocumentTypeRepository documentTypeRepository = Mockito.mock(DocumentTypeRepository.class);
  String organizationId = "organizationId";
  String groupId = "groupId";
  String documentName = "documentName";
  String createdUser = "createdUser";
  String documentTypeId = "documentTypeId";
  LocalDate createdDate = LocalDate.now();
  String description = "description";
  String journalEntryId = "journalEntryId";
  MultipartFile file = Mockito.mock(MultipartFile.class);
  DocumentInput documentInput = Mockito.mock(DocumentInput.class);

  @BeforeEach
  void setup() throws DocumentCreationException, IOException
  {
    Mockito.when(documentInput.getDocumentTypeId()).thenReturn(documentTypeId);
    Mockito.when(documentInput.getOrganizationId()).thenReturn(organizationId);
    Mockito.when(documentInput.getGroupId()).thenReturn(groupId);
    Mockito.when(documentInput.getDocumentName()).thenReturn(documentName);
    Mockito.when(documentInput.getCreatedUser()).thenReturn(createdUser);
    Mockito.when(documentInput.getCreatedDate()).thenReturn(createdDate);
    Mockito.when(documentInput.getDescription()).thenReturn(description);
    Mockito.when(documentInput.getJournalEntryId()).thenReturn(journalEntryId);
    Mockito.when(documentInput.getFile()).thenReturn(file);

    Mockito.when(documentRepository.upload(Mockito.any(Document.class))).thenReturn("alfrescoId");
  }

  @Test
  void executeThrowsExceptionWhenOrganizationIdNull()
  {
    Mockito.when(documentInput.getOrganizationId()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenGroupIdNull()
  {
    Mockito.when(documentInput.getGroupId()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenDocumentNameNull()
  {
    Mockito.when(documentInput.getDocumentName()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenCreatedUserNull()
  {
    Mockito.when(documentInput.getCreatedUser()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenDocumentTypeIdNull()
  {
    Mockito.when(documentInput.getDocumentTypeId()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenDescriptionNull()
  {
    Mockito.when(documentInput.getDescription()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenJournalEntryIdNull()
  {
    Mockito.when(documentInput.getJournalEntryId()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeThrowsExceptionWhenUploadThrowsIOException() throws DocumentCreationException, IOException
  {
    Mockito.when(documentRepository.upload(Mockito.any(Document.class))).thenThrow(IOException.class);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(documentInput));
  }

  @Test
  void executeCreatesDocument() throws DocumentCreationException
  {
    Assertions.assertEquals("alfrescoId", createDocument().execute(documentInput));
  }

  private CreateDocument createDocument()
  {
    return new CreateDocument(documentRepository, documentTypeRepository);
  }
}