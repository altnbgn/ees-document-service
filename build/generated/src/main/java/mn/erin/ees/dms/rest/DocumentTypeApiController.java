package mn.erin.ees.dms.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-26T14:41:06.294612900+08:00[Asia/Ulaanbaatar]")
@Controller
@RequestMapping("${openapi.eESDocumentREST.base-path:/documentApi}")
public class DocumentTypeApiController implements DocumentTypeApi {

    private final DocumentTypeApiDelegate delegate;

    public DocumentTypeApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) DocumentTypeApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DocumentTypeApiDelegate() {});
    }

    @Override
    public DocumentTypeApiDelegate getDelegate() {
        return delegate;
    }

}
