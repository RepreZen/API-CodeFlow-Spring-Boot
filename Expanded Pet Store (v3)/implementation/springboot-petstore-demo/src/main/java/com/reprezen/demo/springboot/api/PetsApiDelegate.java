package com.reprezen.demo.springboot.api;

import com.reprezen.demo.springboot.model.Error;
import com.reprezen.demo.springboot.model.NewPet;
import com.reprezen.demo.springboot.model.Pet;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * A delegate to be called by the {@link PetsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface PetsApiDelegate {

    /**
     * @see PetsApi#addPet
     */
    ResponseEntity<Pet> addPet( NewPet  newPet);

    /**
     * @see PetsApi#deletePet
     */
    ResponseEntity<Void> deletePet( Long  id);

    /**
     * @see PetsApi#findPetById
     */
    ResponseEntity<Pet> findPetById( Long  id);

    /**
     * @see PetsApi#findPets
     */
    ResponseEntity<List<Pet>> findPets( List<String>  tags,
         Integer  limit);

    /**
     * @see PetsApi#updatePet
     */
    ResponseEntity<Pet> updatePet( Long  id,
         NewPet  newPet);

}
