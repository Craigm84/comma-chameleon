package com.lbg.project.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.project.domain.Property;
import com.lbg.project.dto.PropertyDTO;
import com.lbg.project.services.PropertyServices;

@RestController
@CrossOrigin
@RequestMapping("/property")
public class PropertyController {

	private PropertyServices service;

	public PropertyController(PropertyServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Property> createProperty(@RequestBody Property newProperty) {
		return this.service.createProperty(newProperty);
	}

	@GetMapping("/get")
	public List<Property> getProperties() {
		return this.service.getProperty();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PropertyDTO> getProperty(@PathVariable int id) {
		return this.service.getProperty(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Property> updateProperty(@PathVariable int id, @RequestBody Property newProperty) {
		return this.service.updateProperty(id, newProperty);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);
	}

}
