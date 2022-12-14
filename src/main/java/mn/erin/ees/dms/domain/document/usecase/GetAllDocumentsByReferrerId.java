package mn.erin.ees.dms.domain.document.usecase;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import mn.erin.ees.dms.domain.document.api.DocumentOutput;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentGettingException;
import mn.erin.ees.dms.utilities.ExceptionReason;

/**
 * @author Altanbagana
 */
public class GetAllDocumentsByReferrerId
{
  private final DocumentRepository documentRepository;

  public GetAllDocumentsByReferrerId(DocumentRepository documentRepository)
  {
    this.documentRepository = documentRepository;
  }

  public List<DocumentOutput> execute(String referrerId) throws DocumentGettingException
  {
    if (StringUtils.isBlank(referrerId))
    {
      throw new DocumentGettingException(ExceptionReason.INPUT_INVALID, "referrer id is blank");
    }

    try
    {
      List<Document> document = documentRepository.findAllByReferrerId(referrerId);
      ConvertToDocumentOutput documentOutput = new ConvertToDocumentOutput();
      return document.stream().map(documentOutput::convertToDocumentOutput).collect(Collectors.toList());
    }
    catch (DocumentGettingException e)
    {
      return Collections.emptyList();
    }
  }
}
