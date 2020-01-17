/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.2.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.reprezen.demo.springboot.api;

import com.reprezen.demo.springboot.model.Error;
import com.reprezen.demo.springboot.model.NewPet;
import com.reprezen.demo.springboot.model.Pet;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Validated
@Api(value = "pets", description = "the pets API")
public interface PetsApi {

    @ApiOperation(value = "", nickname = "addPet", notes = "Creates a new pet in the store.  Duplicates are allowed", response = Pet.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "pet response", response = Pet.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/pets",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Pet> addPet(@ApiParam(value = "Pet to add to the store" ,required=true )  @Valid @RequestBody NewPet newPet);


    @ApiOperation(value = "", nickname = "deletePet", notes = "deletes a single pet based on the ID supplied", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "pet deleted"),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/pets/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePet(@ApiParam(value = "ID of pet to delete",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "", nickname = "findPetById", notes = "Returns a user based on a single ID, if the user does not have access to the pet", response = Pet.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "pet response", response = Pet.class),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/pets/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Pet> findPetById(@ApiParam(value = "ID of pet to fetch",required=true) @PathVariable("id") Long id);


    @ApiOperation(value = "", nickname = "findPets", notes = "Returns all pets from the system that the user has access to Nam sed condimentum est. Maecenas tempor sagittis sapien, nec rhoncus sem sagittis sit amet. Aenean at gravida augue, ac iaculis sem. Curabitur odio lorem, ornare eget elementum nec, cursus id lectus. Duis mi turpis, pulvinar ac eros ac, tincidunt varius justo. In hac habitasse platea dictumst. Integer at adipiscing ante, a sagittis ligula. Aenean pharetra tempor ante molestie imperdiet. Vivamus id aliquam diam. Cras quis velit non tortor eleifend sagittis. Praesent at enim pharetra urna volutpat venenatis eget eget mauris. In eleifend fermentum facilisis. Praesent enim enim, gravida ac sodales sed, placerat id erat. Suspendisse lacus dolor, consectetur non augue vel, vehicula interdum libero. Morbi euismod sagittis libero sed lacinia.  Sed tempus felis lobortis leo pulvinar rutrum. Nam mattis velit nisl, eu condimentum ligula luctus nec. Phasellus semper velit eget aliquet faucibus. In a mattis elit. Phasellus vel urna viverra, condimentum lorem id, rhoncus nibh. Ut pellentesque posuere elementum. Sed a varius odio. Morbi rhoncus ligula libero, vel eleifend nunc tristique vitae. Fusce et sem dui. Aenean nec scelerisque tortor. Fusce malesuada accumsan magna vel tempus. Quisque mollis felis eu dolor tristique, sit amet auctor felis gravida. Sed libero lorem, molestie sed nisl in, accumsan tempor nisi. Fusce sollicitudin massa ut lacinia mattis. Sed vel eleifend lorem. Pellentesque vitae felis pretium, pulvinar elit eu, euismod sapien. ", response = Pet.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "pet response", response = Pet.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = Error.class) })
    @RequestMapping(value = "/pets",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Pet>> findPets(@ApiParam(value = "tags to filter by") @Valid @RequestParam(value = "tags", required = false) List<String> tags,@ApiParam(value = "maximum number of results to return") @Valid @RequestParam(value = "limit", required = false) Integer limit);

}
