package com.lbg.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project.domain.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer> {

}
