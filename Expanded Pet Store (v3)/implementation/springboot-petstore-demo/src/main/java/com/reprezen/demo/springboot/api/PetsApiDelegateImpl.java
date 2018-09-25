package com.reprezen.demo.springboot.api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.reprezen.demo.springboot.api.PetsApiDelegate;
import com.reprezen.demo.springboot.model.NewPet;
import com.reprezen.demo.springboot.model.Pet;

@Service
public class PetsApiDelegateImpl implements PetsApiDelegate {

	private final Map<Long, Pet> pets = Maps.newHashMap();
	private long nextId = 0l;

	@Override
	public ResponseEntity<Pet> addPet(NewPet newPet) {
		Pet petToAdd = new Pet();
		petToAdd.id(nextId++).name(newPet.getName()).tag(newPet.getTag());
		pets.put(petToAdd.getId(), petToAdd);
		return new ResponseEntity<>(petToAdd, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Void> deletePet(Long id) {
		if (!pets.containsKey(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pets.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Pet> findPetById(Long id) {
		if (!pets.containsKey(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pets.get(id), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<List<Pet>> findPets(List<String> tags, Integer limitObject) {
		int limit = limitObject == null ? Integer.MAX_VALUE : limitObject;
		List<Pet> filteredPets = pets.values().stream()//
				.filter(pet -> (tags == null || tags.isEmpty()) ? true : tags.contains(pet.getTag()))//
				.limit(limit)//
				.collect(Collectors.toList());
		return new ResponseEntity<>(filteredPets, HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Pet> updatePet(Long id, NewPet newPet) {
		if (!pets.containsKey(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		pets.get(id).name(newPet.getName()).tag(newPet.getTag());
		return new ResponseEntity<>(pets.get(id), HttpStatus.ACCEPTED);
	}

}
