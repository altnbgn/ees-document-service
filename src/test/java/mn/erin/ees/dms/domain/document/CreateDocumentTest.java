package mn.erin.ees.dms.domain.document;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.usecase.CreateDocument;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.repository.DocumentTypeRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;

class CreateDocumentTest
{
  DocumentRepository documentRepository;
  DocumentTypeRepository documentTypeRepository;
  LocalDate date;
  DocumentInput input;
  DocumentType documentType;

  @BeforeEach
  void setup() throws IOException
  {
    documentRepository = Mockito.mock(DocumentRepository.class);
    documentTypeRepository = Mockito.mock(DocumentTypeRepository.class);
    date = LocalDate.parse("2020-07-06");
    input = Mockito.mock(DocumentInput.class);
    documentType = Mockito.mock(DocumentType.class);

    //input
    Mockito.when(input.getCreatedDate()).thenReturn(date);
    Mockito.when(input.getOrganizationId()).thenReturn("organizationId");
    Mockito.when(input.getGroupId()).thenReturn("groupId");
    Mockito.when(input.getDocumentType()).thenReturn("type");
    Mockito.when(input.getDocumentName()).thenReturn("documentName");
    Mockito.when(input.getCreatedUser()).thenReturn("createdUser");
    Mockito.when(input.getDescription()).thenReturn("description");

    Mockito.when(documentTypeRepository.getDocumentTypeById(input.getDocumentType())).thenReturn(documentType);
    Mockito.when(documentRepository.fileSave(input, documentType)).thenReturn(Mockito.mock(Document.class));
  }

  @Test
  void executeThrowsExceptionWhenOrganizationIdNull()
  {
    Mockito.when(input.getOrganizationId()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsExceptionWhenGroupIdNull()
  {
    Mockito.when(input.getGroupId()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsExceptionWhenDocumentNameNull()
  {
    Mockito.when(input.getDocumentName()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsExceptionWhenCreatedUserNull()
  {
    Mockito.when(input.getCreatedUser()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsExceptionWhenDocumentTypeNull()
  {
    Mockito.when(input.getDocumentType()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsExceptionWhenDescriptionNull()
  {
    Mockito.when(input.getDescription()).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsWhenDocumentTypeNotCreated()
  {
    Mockito.when(documentTypeRepository.getDocumentTypeById(input.getDocumentType())).thenReturn(null);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeThrowsExceptionWhenIOExceptionThrown() throws IOException
  {
    Mockito.when(documentRepository.fileSave(input, documentType)).thenThrow(IOException.class);
    Assertions.assertThrows(DocumentCreationException.class, () ->
        createDocument().execute(input));
  }

  @Test
  void executeCreatesDocument() throws DocumentCreationException
  {
    Assertions.assertNotNull(createDocument().execute(input));
  }

  private CreateDocument createDocument()
  {
    return new CreateDocument(documentRepository, documentTypeRepository);
  }
}