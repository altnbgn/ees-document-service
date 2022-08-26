package mn.erin.ees.dms.domain.document;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.multipart.MultipartFile;

import mn.erin.ees.dms.domain.document.usecase.DocumentDownloadDeleteRepository;
import mn.erin.ees.dms.domain.document.usecase.DocumentRepository;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.model.DocumentInput;
import mn.erin.ees.dms.domain.document.usecase.CreateDocument;
import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.usecase.DocumentTypeRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;

class CreateDocumentTest
{
  private DocumentRepository documentRepository;
  private DocumentDownloadDeleteRepository documentDownloadDeleteRepository;
  private DocumentTypeRepository documentTypeRepository;
  private GridFsTemplate gridFsTemplate;
  private CreateDocument usecase;
  LocalDate date = LocalDate.parse("2020-07-06");
  @BeforeEach
  void setup() throws IOException, DocumentCreationException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    documentRepository = Mockito.mock(DocumentRepository.class);
    documentTypeRepository = Mockito.mock(DocumentTypeRepository.class);
    gridFsTemplate=Mockito.mock(GridFsTemplate.class);
    documentDownloadDeleteRepository=Mockito.mock(DocumentDownloadDeleteRepository.class);
    Document dms = new Document("1234", "a", "b" , "c","123", "e",date, "m","l");
    Mockito.doReturn(dms).when(documentRepository).save(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    DocumentType type = new DocumentType("123", "", "a","b","e","d","d");
    Mockito.doReturn(type).when(documentTypeRepository).getDocumentTypeById("123");
    usecase = new CreateDocument(documentRepository,documentTypeRepository,gridFsTemplate,documentDownloadDeleteRepository);
  }
  @Test
  void throws_exception_if_organizationID_is_missing() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("  ", "b", "c","d","e",date,"f",file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void throws_exception_if_groupID_is_missing() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "", "c","d","e",date,"f",file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void throws_exception_if_documentName_is_missing() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "","d","e",date,"f",file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void throws_exception_if_createdUser_is_missing() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "c","","e",date,"f",file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void throws_exception_if_documentType_is_missing() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "c","d","",date,"f",file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void throws_exception_if_documentType_is_not_found() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "c","d","456",date,"f",file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void creates_document() throws DocumentCreationException, IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "c","d","123",date,"f",file);
    Mockito.doReturn("XYZ").when(documentRepository).fileSave(file);
    usecase.execute(input);
    Mockito.verify(documentRepository)
        .save(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.eq("XYZ"));
  }
  @Test
  void throws_exception_if_contentId_is_null() throws DocumentCreationException, IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "c","d","123",date,"f",file);
    Mockito.doReturn("").when(documentRepository).fileSave(file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
  }
  @Test
  void deleteBy_document() throws IOException
  {
    MultipartFile file = Mockito.mock(MultipartFile.class);
    Mockito.doReturn("test".getBytes(StandardCharsets.UTF_8)).when(file).getBytes();
    DocumentInput input = new DocumentInput("a", "b", "c","d","123",date,"f",file);
    Mockito.doReturn(null).when(documentRepository).save(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    Mockito.doReturn("XYZ").when(documentRepository).fileSave(file);
    Assertions.assertThrows(DocumentCreationException.class, ()->{
      usecase.execute(input);
    });
    Mockito.verify(documentDownloadDeleteRepository).deleteById("XYZ");
  }
}