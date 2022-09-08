package mn.erin.ees.dms.domain.document.repository.alfresco_repository;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentCreationException;

/**
 * @author Altanbagana
 */
@Configuration @PropertySource("classpath:application.properties-test")
class DocumentRepositoryAlfrescoImplTest
{
  DocumentRepository documentRepository;

  Document document = new Document("id", "test", "test", "test", "test", "test", LocalDate.now(), "test", "test", null);

  @Test
  void upload()
  {
    Assertions.assertEquals(1,1);
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