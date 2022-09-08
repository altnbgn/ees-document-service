package mn.erin.ees.dms.domain.document.usecase;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import mn.erin.ees.dms.domain.document.api.DocumentOutput;
import mn.erin.ees.dms.domain.document.model.Document;

/**
 * @author Altanbagana
 */
class ConvertToDocumentOutputTest
{
  @Test
  void convertToDocumentOutputTest()
  {
    String id = "id";
    String organizationId = "organizationId";
    String groupId = "groupId";
    String documentName = "documentName";
    String documentType = "documentType";
    String createdUser = "createdUser";
    LocalDate createdDate = LocalDate.now();
    String description = "description";
    String referrerId = "referrerId";

    Document document = new Document(id, documentName, organizationId, groupId, createdUser, documentType, createdDate, referrerId, description, null);
    DocumentOutput documentOutput = new ConvertToDocumentOutput().convertToDocumentOutput(document);

    Assertions.assertEquals(id, documentOutput.getContentId());
    Assertions.assertEquals(documentName, documentOutput.getName());
    Assertions.assertEquals(documentType, documentOutput.getContentTypeId());
  }
}