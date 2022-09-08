package mn.erin.ees.dms.domain.document.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.utilities.DocumentCreationException;
import mn.erin.ees.dms.utilities.DocumentGettingException;

public interface DocumentRepository
{
  String upload(Document document) throws DocumentCreationException, IOException;

  Document findByReferrerIdAndName(String referrerId, String name) throws DocumentGettingException;

  List<Document> findAllByReferrerId(String referrerId) throws DocumentGettingException;

  Resource downloadByContentId(String contentId);

  public void deleteById(String contentId);
}
