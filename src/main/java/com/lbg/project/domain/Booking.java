package com.lbg.project.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate date;

	private LocalTime time;
//awaiting relationships between domains
	// @JsonBackReference
	// @ManyToOne
	// private Property property;

	// @JsonBackReference
	// @ManyToOne
	// private Buyer buyer;

	public Booking() {
		super();
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

//	public Property getProperty() {
//		return property;
//	}
//
//	public void setProperty(Property property) {
//		this.property = property;
//	}
//
//	public Buyer getBuyer() {
//		return buyer;
//	}
//
//	public void setBuyer(Buyer buyer) {
//		this.buyer = buyer;
//	}

}
