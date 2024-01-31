package com.lbg.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project.domain.Buyer;

public interface BuyerRepo extends JpaRepository<Buyer, Integer> {

}
