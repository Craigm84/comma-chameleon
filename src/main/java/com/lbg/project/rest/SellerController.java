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

import com.lbg.project.domain.Seller;
import com.lbg.project.services.SellerServices;

@RestController
@CrossOrigin
@RequestMapping("/seller")
public class SellerController {
	private SellerServices service;

	public SellerController(SellerServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Seller> createSeller(@RequestBody Seller newSeller) {
		return this.service.createSeller(newSeller);
	}

	@GetMapping("/get")
	public List<Seller> getSellers() {
		return this.service.getSellers();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Seller> getSeller(@PathVariable int id) {
		return this.service.getSeller(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Seller> updateSeller(@PathVariable int id, @RequestBody Seller sellerDetails) {
		return this.service.updateSeller(id, sellerDetails);

	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteSeller(@PathVariable int id) {
		return this.service.deleteSeller(id);

	}
}
