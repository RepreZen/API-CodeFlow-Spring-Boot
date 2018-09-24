package com.reprezen.demo.springboot.api;

import com.reprezen.demo.springboot.model.Error;
import com.reprezen.demo.springboot.model.NewPet;
import com.reprezen.demo.springboot.model.Pet;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("${openapi.swaggerPetstore.base-path:/api}")
public class PetsApiController implements PetsApi {

    private final PetsApiDelegate delegate;

    public PetsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) PetsApiDelegate delegate) {
        this.delegate = delegate;
    }

    public ResponseEntity<Pet> addPet(@ApiParam(value = "Pet to add to the store" ,required=true )  @Valid @RequestBody NewPet newPet) {
        return delegate.addPet(newPet);
    }

    public ResponseEntity<Void> deletePet(@ApiParam(value = "ID of pet to delete",required=true) @PathVariable("id") Long id) {
        return delegate.deletePet(id);
    }

    public ResponseEntity<Pet> findPetById(@ApiParam(value = "ID of pet to fetch",required=true) @PathVariable("id") Long id) {
        return delegate.findPetById(id);
    }

    public ResponseEntity<List<Pet>> findPets(@ApiParam(value = "tags to filter by") @Valid @RequestParam(value = "tags", required = false) List<String> tags,@ApiParam(value = "maximum number of results to return") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        return delegate.findPets(tags, limit);
    }

}
