package com.lbg.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project.domain.Booking;

public interface BookingsRepo extends JpaRepository<Booking, Integer> {

}
