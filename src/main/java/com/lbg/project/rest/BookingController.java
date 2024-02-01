package com.lbg.project.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.project.domain.Booking;
import com.lbg.project.services.BookingServices;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

	private BookingServices service;

	public BookingController(BookingServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Booking createBooking(@RequestBody Booking newBooking) {
		return this.service.createBooking(newBooking);
	}

	@GetMapping("/get")
	public List<Booking> getBookings() {
		return this.service.getBookings();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
		return this.service.getBookingById(id);
	}

	@PatchMapping("/update/{id}")
	public ResponseEntity<Booking> updateById(@PathVariable int id, @RequestBody Booking newBooking) {
		return this.service.updateById(id, newBooking);
	}

	@DeleteMapping("cancel/{id}")
	public boolean cancelBookingById(@PathVariable int id) {
		return this.service.cancelBookingById(id);
	}

}
