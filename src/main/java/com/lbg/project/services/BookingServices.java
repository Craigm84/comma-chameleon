package com.lbg.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.project.domain.Booking;
import com.lbg.project.repos.BookingsRepo;

@Service
public class BookingServices {

	private BookingsRepo repo;

	public BookingServices(BookingsRepo repo) {
		super();
		this.repo = repo;
	}

	public Booking createBooking(Booking newBooking) {
		return this.repo.save(newBooking);

	}

	public List<Booking> getBookings() {
		return this.repo.findAll();

	}

	public ResponseEntity<Booking> getBookingById(int id) {
		Optional<Booking> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(found.get());

	}

	public ResponseEntity<Booking> updateById(int id, Booking newBooking) {
		Optional<Booking> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Booking made = found.get();

		if (newBooking.getDate() != null) {
			made.setDate(newBooking.getDate());
		}
		if (newBooking.getTime() != null) {
			made.setTime(newBooking.getTime());
		}
		Booking body = this.repo.save(made);

		return ResponseEntity.ok(body);
	}

	public boolean cancelBookingById(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

}
