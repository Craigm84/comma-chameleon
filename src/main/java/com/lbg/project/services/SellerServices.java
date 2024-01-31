package com.lbg.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project.domain.Seller;
import com.lbg.project.repos.SellerRepo;

@Service
public class SellerServices {

	private SellerRepo repo;

	public SellerServices(SellerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Seller> createSeller(Seller newSeller) {
		Seller created = this.repo.save(newSeller);
		return new ResponseEntity<Seller>(created, HttpStatus.CREATED);
	}

	public List<Seller> getSellers() {
		return this.repo.findAll();
	}

	public ResponseEntity<Seller> getSeller(int id) {
		Optional<Seller> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
		}

		Seller body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Seller> updateSeller(int id, Seller sellerDetails) {
		Optional<Seller> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
		}
		Seller existing = found.get();
		if (sellerDetails.getFirstName() != null) {
			existing.setFirstName(sellerDetails.getFirstName());
		}

		if (sellerDetails.getLastName() != null) {
			existing.setLastName(sellerDetails.getLastName());
		}
		Seller updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

	public boolean deleteSeller(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}
}
