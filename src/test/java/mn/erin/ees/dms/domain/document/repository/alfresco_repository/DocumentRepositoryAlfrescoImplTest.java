package mn.erin.ees.dms.domain.document.repository.alfresco_repository;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;

/**
 * @author Altanbagana
 */
@Disabled
class DocumentRepositoryAlfrescoImplTest
{
  DocumentRepositoryAlfrescoImpl documentRepository;

  Document document = new Document("id", "test", "test", "test", "test", "test", LocalDate.now(), "test", "test", null);

  @Test
  void upload()
  {
  }

  @Test
  void findByReferrerIdAndName()
  {
  }

  @Test
  void findAllByReferrerId()
  {
  }

  @Test
  void downloadByContentId()
  {
  }

  @Test
  void deleteById()
  {
  }
}