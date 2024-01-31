package com.lbg.project.services;

import org.springframework.stereotype.Service;

import com.lbg.project.repos.BuyerRepo;

@Service
public class BuyerServices {
	private BuyerRepo repo;

	public BuyerServices(BuyerRepo repo) {
		super();
		this.repo = repo;
	}

}
