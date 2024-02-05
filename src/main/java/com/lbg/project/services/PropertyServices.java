package com.lbg.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project.domain.Property;
import com.lbg.project.dto.PropertyDTO;
import com.lbg.project.repos.PropertyRepo;

@Service
public class PropertyServices {

	private PropertyRepo repo;

	public PropertyServices(PropertyRepo repo) {
		super();
		this.repo = repo;
	}

//	Creates new property
	public ResponseEntity<Property> createProperty(Property newProperty) {
		Property created = this.repo.save(newProperty);
		return new ResponseEntity<Property>(created, HttpStatus.CREATED);
	}

//	Returns all properties that exist
	public List<Property> getProperty() {
		return this.repo.findAll();
	}

//	Find property by ID
	public ResponseEntity<PropertyDTO> getProperty(int id) {
//		Creates a container which could have a property
		Optional<Property> found = this.repo.findById(id);
//		Checks if the container is empty, if yes then returns not found
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
//		Checks if the container contains a property, then returns the property
		Property body = found.get();
		return ResponseEntity.ok(new PropertyDTO(body));
	}

//	Update property data
	public ResponseEntity<Property> updateProperty(int id, Property newProperty) {
//		Creates a container which could have a property
		Optional<Property> found = this.repo.findById(id);
//		Checks if the container is empty, if yes then returns not found
		if (found.isEmpty()) {
			return new ResponseEntity<Property>(HttpStatus.NOT_FOUND);
		}
//		Checks if the container contains a property, then returns the property
		Property existing = found.get();

		if (newProperty.getAddress() != null) {
			existing.setAddress(newProperty.getAddress());
		}
		if (newProperty.getCity() != null) {
			existing.setCity(newProperty.getCity());
		}
		if (newProperty.getType() != null) {
			existing.setType(newProperty.getType());
		}
		if (newProperty.getBedroom() != 0) {
			existing.setBedroom(newProperty.getBedroom());
		}
		if (newProperty.getBathroom() != 0) {
			existing.setBathroom(newProperty.getBathroom());
		}
		if (newProperty.getPrice() != 0) {
			existing.setPrice(newProperty.getPrice());
		}
		if (newProperty.getGarden() != null) {
			existing.setGarden(newProperty.getGarden());
		}
		if (newProperty.getStatus() != null) {
			existing.setStatus(newProperty.getStatus());
		}
		if (newProperty.getImage() != null) {
			existing.setImage(newProperty.getImage());
		}

		Property updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

//	Remove property by ID
	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

}
