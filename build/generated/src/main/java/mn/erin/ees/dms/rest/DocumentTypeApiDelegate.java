package mn.erin.ees.dms.rest;

import mn.erin.ees.dms.rest.model.DocumentTypePayloadRestModel;
import mn.erin.ees.dms.rest.model.DocumentTypeRestModel;
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
 * A delegate to be called by the {@link DocumentTypeApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-26T16:09:31.991869400+08:00[Asia/Ulaanbaatar]")
public interface DocumentTypeApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /document-type/create/{organizationId} : create a document type
     *
     * @param organizationId ID of the organization (required)
     * @param documentTypePayloadRestModel  (required)
     * @return return new document type (status code 201)
     * @see DocumentTypeApi#createDocumentType
     */
    default ResponseEntity<DocumentTypeRestModel> createDocumentType(String organizationId,
        DocumentTypePayloadRestModel documentTypePayloadRestModel) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : \"organizationId\", \"createdBy\" : \"createdBy\", \"groupId\" : \"groupId\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /document-type/get/{organizationId}/{groupId} : returns all document types
     *
     * @param organizationId ID of the organization (required)
     * @param groupId ID of the group (required)
     * @return Available document list (status code 201)
     * @see DocumentTypeApi#getDocumentTypes
     */
    default ResponseEntity<List<DocumentTypeRestModel>> getDocumentTypes(String organizationId,
        String groupId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"organizationId\" : \"organizationId\", \"createdBy\" : \"createdBy\", \"groupId\" : \"groupId\", \"name\" : \"name\", \"description\" : \"description\", \"id\" : \"id\", \"category\" : \"category\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
