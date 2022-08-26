package mn.erin.ees.dms.rest;

import mn.erin.ees.dms.rest.model.DocumentRestModel;
import mn.erin.ees.dms.rest.model.ErrorRestModel;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link DocumentApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-26T16:09:31.849872100+08:00[Asia/Ulaanbaatar]")
public interface DocumentApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /document/create/{organizationId}/{groupId}/{createdUser}/{documentName}/{documentType}/{createdDate}/{description} : upload documents
     *
     * @param organizationId ID of the organization (required)
     * @param groupId ID of the group (required)
     * @param createdUser ID of the user (required)
     * @param documentName ID of the organization (required)
     * @param documentType ID of the group (required)
     * @param createdDate ID of the user (required)
     * @param description ID of the user (required)
     * @param file  (required)
     * @return Successful (status code 201)
     *         or Input data invalid (status code 400)
     *         or Unauthorized (status code 401)
     *         or Selected folder does not exit (status code 404)
     *         or General document list JSON model (status code 200)
     * @see DocumentApi#createDocument
     */
    default ResponseEntity<DocumentRestModel> createDocument(String organizationId,
        String groupId,
        String createdUser,
        String documentName,
        String documentType,
        String createdDate,
        String description,
        MultipartFile file) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : \"organizationId\", \"date\" : \"date\", \"path\" : \"path\", \"file\" : \"file\", \"groupId\" : \"groupId\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"type\" : \"type\", \"createdUser\" : \"createdUser\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /document/get/{organizationId}/{groupId} : returns all documents
     *
     * @param organizationId ID of the organization (required)
     * @param groupId ID of the group (required)
     * @return Document list (status code 200)
     * @see DocumentApi#getDocuments
     */
    default ResponseEntity<List<DocumentRestModel>> getDocuments(String organizationId,
        String groupId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : \"organizationId\", \"date\" : \"date\", \"path\" : \"path\", \"file\" : \"file\", \"groupId\" : \"groupId\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"type\" : \"type\", \"createdUser\" : \"createdUser\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /document/content/{contentId} : return file
     *
     * @param contentId ID of the content (required)
     * @return Success (status code 200)
     * @see DocumentApi#getFile
     */
    default ResponseEntity<org.springframework.core.io.Resource> getFile(String contentId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
