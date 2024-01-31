package com.lbg.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project.domain.Buyer;
import com.lbg.project.repos.BuyerRepo;

@Service
public class BuyerServices {
	private BuyerRepo repo;

	public BuyerServices(BuyerRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Buyer> createBuyer(Buyer newBuyer) {
		Buyer created = this.repo.save(newBuyer);
		return new ResponseEntity<Buyer>(created, HttpStatus.CREATED);
	}

	public List<Buyer> getBuyers() {
		return this.repo.findAll();
	}

	public ResponseEntity<Buyer> getBuyer(int id) {
		Optional<Buyer> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
		}

		Buyer body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Buyer> updateBuyer(int id, Buyer buyerDetails) {
		Optional<Buyer> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
		}
		Buyer existing = found.get();

		if (buyerDetails.getFirstName() != null) {
			existing.setFirstName(buyerDetails.getFirstName());
		}
		if (buyerDetails.getLastName() != null) {
			existing.setLastName(buyerDetails.getLastName());
		}

		Buyer updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deleteBuyer(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
