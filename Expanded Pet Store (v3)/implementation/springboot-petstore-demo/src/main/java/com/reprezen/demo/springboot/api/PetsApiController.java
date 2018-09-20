package com.reprezen.demo.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2018-09-20T14:14:53.886-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.swaggerPetstore.base-path:/api}")
public class PetsApiController implements PetsApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PetsApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
