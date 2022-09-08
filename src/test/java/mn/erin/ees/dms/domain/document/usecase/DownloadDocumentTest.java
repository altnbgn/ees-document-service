package mn.erin.ees.dms.domain.document.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.Resource;

import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.DocumentGettingException;

/**
 * @author Altanbagana
 */
class DownloadDocumentTest
{
  String contentId;
  DocumentRepository documentRepository;

  @BeforeEach
  void setup()
  {
    contentId = "contentId";
    documentRepository = Mockito.mock(DocumentRepository.class);

    Mockito.when(documentRepository.downloadByContentId(contentId)).thenReturn(Mockito.mock(Resource.class));
  }

  @Test
  void executeThrowsExceptionWhenContentIdNull()
  {
    Assertions.assertThrows(DocumentGettingException.class, () ->
        downloadDocument().execute(null));
  }

  @Test
  void downloadsDocument() throws DocumentGettingException
  {
    Assertions.assertNotNull(downloadDocument().execute(contentId));
  }

  private DownloadDocument downloadDocument()
  {
    return new DownloadDocument(documentRepository);
  }
}