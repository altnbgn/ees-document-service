package mn.erin.ees.dms.domain.document.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentGettingException;

/**
 * @author Altanbagana
 */
class GetDocumentTest
{
  DocumentRepository documentRepository;
  Document documentMock;
  String referrerId;
  String documentName;
  String documentType;
  String documentId;

  @BeforeEach
  void setup() throws DocumentGettingException
  {
    referrerId = "referrerId";
    documentName = "documentName";
    documentType = "documentType";
    documentId = "documentId";
    documentRepository = Mockito.mock(DocumentRepository.class);
    documentMock = Mockito.mock(Document.class);

    Mockito.when(documentMock.getDocumentName()).thenReturn(documentName);
    Mockito.when(documentMock.getDocumentName()).thenReturn(documentType);
    Mockito.when(documentMock.getDocumentName()).thenReturn(documentId);

    Mockito.when(documentRepository.findByReferrerIdAndName(referrerId, documentName)).thenReturn(documentMock);
  }

  @Test
  void executeThrowsExceptionWhenReferredIdNull()
  {
    Assertions.assertThrows(DocumentGettingException.class,
        () -> getDocument().execute(null, documentName));
  }

  @Test
  void executeThrowsExceptionWhenNameNull()
  {
    Assertions.assertThrows(DocumentGettingException.class,
        () -> getDocument().execute(referrerId, null));
  }

  @Test
  void executeReturnsDocument() throws DocumentGettingException
  {
    Assertions.assertNotNull(getDocument().execute(referrerId, documentName));
  }

  private GetDocument getDocument()
  {
    return new GetDocument(documentRepository);
  }
}