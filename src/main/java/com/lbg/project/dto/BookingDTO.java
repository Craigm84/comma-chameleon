package com.lbg.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.lbg.project.domain.Booking;

public class BookingDTO {

	private Integer id;

	private LocalDate date;

	private LocalTime time;

	private String buyerFirstName;

	private String buyerLastName;

//	private String propertyAddress;

	public BookingDTO() {
		super();

	}

	public BookingDTO(Booking booking) {
		this.setId(booking.getId());
		this.setDate(booking.getDate());
		this.setTime(booking.getTime());
		this.setBuyerFirstName(booking.getBuyer().getFirstName());
		this.setBuyerLastName(booking.getBuyer().getLastName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getBuyerFirstName() {
		return buyerFirstName;
	}

	public void setBuyerFirstName(String buyerFirstName) {
		this.buyerFirstName = buyerFirstName;
	}

	public String getBuyerLastName() {
		return buyerLastName;
	}

	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}

//	public String getPropertyAddress() {
//		return propertyAddress;
//	}
//
//	public void setPropertyAddress(String propertyAddress) {
//		this.propertyAddress = propertyAddress;
//	}

}
