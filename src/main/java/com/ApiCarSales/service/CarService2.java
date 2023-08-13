package com.ApiCarSales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiCarSales.Repository.CarRespository;
import com.ApiCarSales.model.Carro;

@Service
public class CarService2 {
	
	@Autowired
	private CarRespository repository;
	
	 public Carro findById(long id) {
			
			
			Carro car = repository.findById(id).orElseThrow();
			
			
			return car;
		}

}
