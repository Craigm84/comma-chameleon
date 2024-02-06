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

import com.lbg.project.domain.Buyer;
import com.lbg.project.services.BuyerServices;

@RestController
@CrossOrigin
@RequestMapping("/buyer")
public class BuyerController {

	private BuyerServices service;

	public BuyerController(BuyerServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer newBuyer) {
		return this.service.createBuyer(newBuyer);
	}

	@GetMapping("/get")
	public List<Buyer> getBuyers() {
		return this.service.getBuyers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Buyer> getBuyer(@PathVariable int id) {
		return this.service.getBuyer(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Buyer> updateBuyer(@PathVariable int id, @RequestBody Buyer buyerDetails) {
		return this.service.updateBuyer(id, buyerDetails);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteBuyer(@PathVariable int id) {
		return this.service.deleteBuyer(id);
	}

}
