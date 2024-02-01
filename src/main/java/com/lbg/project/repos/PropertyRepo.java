package com.lbg.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.project.domain.Property;

public interface PropertyRepo extends JpaRepository<Property, Integer> {

}
