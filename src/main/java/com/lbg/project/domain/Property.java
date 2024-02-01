package com.lbg.project.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private int bedroom;
	@Column(nullable = false)
	private int bathroom;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private Boolean garden;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String image;
	@Column(nullable = false)
	@JsonManagedReference
	@OneToMany(mappedBy = "property")
	private List<Booking> bookings;

	public Property() {
		super();
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

	public Boolean getGarden() {
		return garden;
	}

	public void setGarden(Boolean garden) {
		this.garden = garden;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
