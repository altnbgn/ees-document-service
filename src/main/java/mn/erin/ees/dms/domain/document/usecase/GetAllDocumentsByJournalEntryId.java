package mn.erin.ees.dms.domain.document.usecase;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;

import mn.erin.ees.dms.domain.document.api.DocumentOutput;
import mn.erin.ees.dms.domain.document.model.Document;
import mn.erin.ees.dms.domain.document.repository.DocumentRepository;
import mn.erin.ees.dms.utilities.DocumentGettingException;

/**
 * @author Altanbagana
 */
public class GetAllDocumentsByJournalEntryId
{
  private final DocumentRepository documentRepository;

  public GetAllDocumentsByJournalEntryId(DocumentRepository documentRepository)
  {
    this.documentRepository = documentRepository;
  }

  public List<DocumentOutput> execute(String journalEntryId)
  {
    if (StringUtils.isBlank(journalEntryId))
    {
      throw new ValidationException("journal entry id is blank");
    }

    try
    {
      List<Document> document = documentRepository.findAllByReferrerId(journalEntryId);
      ConvertToDocumentOutput documentOutput = new ConvertToDocumentOutput();
      return document.stream().map(documentOutput::convertToDocumentOutput).collect(Collectors.toList());
    }
    catch (DocumentGettingException e)
    {
      return Collections.emptyList();
    }
  }
}
