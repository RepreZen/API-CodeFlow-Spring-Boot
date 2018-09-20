package com.reprezen.demo.springboot.api.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.google.common.collect.Maps;
import com.reprezen.demo.springboot.api.PetsApi;
import com.reprezen.demo.springboot.model.NewPet;
import com.reprezen.demo.springboot.model.Pet;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("${openapi.swaggerPetstore.base-path:/api}")
public class PetsApiImpl implements PetsApi {

	private final Map<Long, Pet> pets = Maps.newHashMap();
	private long nextId = 0l;

	private final NativeWebRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public PetsApiImpl(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<Pet> addPet(
			@ApiParam(value = "Pet to add to the store", required = true) @Valid @RequestBody NewPet newPet) {
		Pet petToAdd = new Pet();
		petToAdd.id(nextId++).name(newPet.getName()).tag(newPet.getTag());
		pets.put(petToAdd.getId(), petToAdd);
		return new ResponseEntity<>(petToAdd, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deletePet(
			@ApiParam(value = "ID of pet to delete", required = true) @PathVariable("id") Long id) {
		if (!pets.containsKey(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pets.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Pet> findPetById(
			@ApiParam(value = "ID of pet to fetch", required = true) @PathVariable("id") Long id) {
		if (!pets.containsKey(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pets.get(id), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<Pet>> findPets(
			@ApiParam(value = "tags to filter by") @Valid @RequestParam(value = "tags", required = false) List<String> tags,
			@ApiParam(value = "maximum number of results to return") @Valid @RequestParam(value = "limit", required = false) Integer limitObject) {
		int limit = limitObject == null ? Integer.MAX_VALUE : limitObject;
		List<Pet> filteredPets = pets.values().stream()//
				.filter(pet -> (tags == null || tags.isEmpty()) ? true : tags.contains(pet.getTag()))//
				.limit(limit)//
				.collect(Collectors.toList());
		return new ResponseEntity<>(filteredPets, HttpStatus.ACCEPTED);
	}
}
