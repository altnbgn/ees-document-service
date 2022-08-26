package mn.erin.ees.dms.domain.document_type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mn.erin.ees.dms.domain.document_type.model.DocumentType;
import mn.erin.ees.dms.domain.document_type.model.DocumentTypeInput;
import mn.erin.ees.dms.utilities.CreateDocumentTypeException;
import mn.erin.ees.dms.domain.document_type.usecase.DocumentTypeRepository;
import mn.erin.ees.dms.domain.document_type.usecase.CreateDocumentType;

import static org.mockito.Mockito.doReturn;

public class CreateDocumentTypeTest
{
  private DocumentTypeRepository repository;
  private CreateDocumentType usecase;

  @BeforeEach
  void setup()
  {
    repository = Mockito.mock(DocumentTypeRepository.class);
    DocumentType dummy = new DocumentType("123", "", " ", "a", "b", "d","s");
    doReturn(dummy).when(repository).createDocumentType(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    usecase = new CreateDocumentType(repository);
  }

  @Test
  void throws_exception_if_organizationID_is_missing()
  {
    DocumentTypeInput input = new DocumentTypeInput(" ", "b", "c", "d", "e");
    Assertions.assertThrows(CreateDocumentTypeException.class, () -> {
      usecase.execute(input);
    });
  }

  @Test
  void throws_exception_if_groupID_is_missing()
  {
    DocumentTypeInput input = new DocumentTypeInput("a", "", "c", "d", "e");
    Assertions.assertThrows(CreateDocumentTypeException.class, () -> {
      usecase.execute(input);
    });
  }

  @Test
  void throws_exception_if_name_is_missing()
  {
    DocumentTypeInput input = new DocumentTypeInput("a", "b", "", "d", "e");
    Assertions.assertThrows(CreateDocumentTypeException.class, () -> {
      usecase.execute(input);
    });
  }

  @Test
  void throws_exception_if_category_is_missing()
  {
    DocumentTypeInput input = new DocumentTypeInput("a", "b", "c", " ", "e");
    Assertions.assertThrows(CreateDocumentTypeException.class, () -> {
      usecase.execute(input);
    });
  }

  @Test
  void throws_exception_if_name_is_duplicate()
  {
    doReturn(true).when(repository).hasDocumentTypeWithName("c");
    DocumentTypeInput input = new DocumentTypeInput("a", "b", "c", "d", "e");
    Assertions.assertThrows(CreateDocumentTypeException.class, () -> {
      usecase.execute(input);
    });
  }

  @Test
  void creates_document_type() throws Exception
  {
    DocumentTypeInput input = new DocumentTypeInput("a", "b", "c", "d", " ");
    usecase.execute(input);
    Mockito.verify(repository).createDocumentType("a", "b", "c", "d", " ");
  }

  @Test
  void name_is_trimed() throws Exception
  {
    DocumentTypeInput input = new DocumentTypeInput("a", "b", " c ", "d", " ");
    usecase.execute(input);
    Mockito.verify(repository).createDocumentType("a", "b", "c", "d", " ");
  }
}
