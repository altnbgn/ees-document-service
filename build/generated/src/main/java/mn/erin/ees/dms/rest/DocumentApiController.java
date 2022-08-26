package mn.erin.ees.dms.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-26T14:54:11.730668900+08:00[Asia/Ulaanbaatar]")
@Controller
@RequestMapping("${openapi.eESDocumentREST.base-path:/documentApi}")
public class DocumentApiController implements DocumentApi {

    private final DocumentApiDelegate delegate;

    public DocumentApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) DocumentApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new DocumentApiDelegate() {});
    }

    @Override
    public DocumentApiDelegate getDelegate() {
        return delegate;
    }

}
