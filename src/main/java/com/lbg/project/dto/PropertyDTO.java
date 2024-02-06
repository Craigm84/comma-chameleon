package com.lbg.project.dto;

import java.util.ArrayList;
import java.util.List;

import com.lbg.project.domain.Booking;
import com.lbg.project.domain.Property;

public class PropertyDTO {

	private Integer id;

	private String address;

	private String city;

	private String type;

	private int bedroom;

	private int bathroom;

	private double price;

	private String garden;

	private String status;

	private String image;

	private List<BookingDTO> bookings = new ArrayList<BookingDTO>();

	public PropertyDTO() {
		super();
	}

	public PropertyDTO(Property property) {
		this.setId(property.getId());
		this.setAddress(property.getAddress());
		this.setCity(property.getCity());
		this.setType(property.getType());
		this.setBedroom(property.getBedroom());
		this.setBathroom(property.getBathroom());
		this.setPrice(property.getPrice());
		this.setGarden(property.getGarden());
		this.setStatus(property.getStatus());
		this.setImage(property.getImage());

		for (Booking booking : property.getBookings()) {
			this.bookings.add(new BookingDTO(booking));
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBedroom() {
		return bedroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGarden() {
		return garden;
	}

	public void setGarden(String garden) {
		this.garden = garden;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BookingDTO> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDTO> bookings) {
		this.bookings = bookings;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
