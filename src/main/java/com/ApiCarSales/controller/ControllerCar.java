package com.ApiCarSales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiCarSales.model.vo.CarroVo;
import com.ApiCarSales.service.ServiceCar;



@RestController
@RequestMapping(value = "/car")
public class ControllerCar {
	
	@Autowired(required = true)
	private ServiceCar service;
	
	@PostMapping()
	public CarroVo create(@RequestBody CarroVo car){
		
		return service.saveCar(car);
	}
	
	@GetMapping
	public List<CarroVo> findAll(){
		
		return service.findAll();
		
	}
	
	@GetMapping(value = "/{id}")
	public CarroVo findById(@PathVariable(value = "id") long id) {
		return service.findById(id);
	}
	@GetMapping(value = "name/{nome}")
	public List<CarroVo> findByName(@PathVariable(value = "nome") String nome) {
		return service.findByNameCar(nome);
	}
	
	@PutMapping()
	public CarroVo update(@RequestBody CarroVo car) {
		return service.updateCar(car);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		service.deleteCar(id);
	}
}

