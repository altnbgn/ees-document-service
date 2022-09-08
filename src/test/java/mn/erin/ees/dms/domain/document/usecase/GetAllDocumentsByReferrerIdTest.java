package mn.erin.ees.dms.domain.document.usecase;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentGettingException;

/**
 * @author Altanbagana
 */
class GetAllDocumentsByReferrerIdTest
{
  DocumentRepository documentRepository;
  String referrerId;

  @BeforeEach
  void setup() throws DocumentGettingException
  {
    referrerId = "referrerId";
    documentRepository = Mockito.mock(DocumentRepository.class);
    Mockito.when(documentRepository.findAllByReferrerId(referrerId)).thenReturn(Collections.emptyList());
  }

  @Test
  void executeThrowsExceptionWhenReferrerIdNull()
  {
    Assertions.assertThrows(DocumentGettingException.class,
        () -> getAllDocumentsByReferrerId().execute(null));
  }

  @Test
  void executeReturnsEmptyListWhenDocumentGettingExceptionThrown() throws DocumentGettingException
  {
    Mockito.when(documentRepository.findAllByReferrerId(referrerId)).thenThrow(DocumentGettingException.class);
    Assertions.assertTrue(getAllDocumentsByReferrerId().execute(referrerId).isEmpty());
  }

  @Test
  void executeReturnsList() throws DocumentGettingException
  {
    Assertions.assertNotNull(getAllDocumentsByReferrerId().execute(referrerId));
  }

  private GetAllDocumentsByReferrerId getAllDocumentsByReferrerId()
  {
    return new GetAllDocumentsByReferrerId(documentRepository);
  }
}