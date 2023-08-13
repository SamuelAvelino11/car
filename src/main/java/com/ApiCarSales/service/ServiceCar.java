package com.ApiCarSales.service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ApiCarSales.Interface.CarInterface;
import com.ApiCarSales.Repository.CarRespository;
import com.ApiCarSales.controller.ControllerCar;
import com.ApiCarSales.model.Carro;
import com.ApiCarSales.model.vo.CarroVo;



@Service
public class ServiceCar implements CarInterface{

	ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private CarRespository repository;
	
	

	@Override
	public List<CarroVo> findAll() {
		List<CarroVo> list = new ArrayList<CarroVo>();
		for (Carro carro : repository.findAll()) {
			list.add(mapper.map(carro, CarroVo.class));
		}
		list
			.stream()
			.forEach(c -> {
				try {
					c.add(linkTo(methodOn(ControllerCar.class).findById(c.getId())).withSelfRel());
				} catch (Exception e) {
					// TODO: handle exception
				}
			});
		return list;
	}

	@Override
	public CarroVo findById(long id) {
		
		
		var car = mapper.map(repository.findById(id), CarroVo.class);
		
		car.add(linkTo(methodOn(ControllerCar.class).findById(car.getId())).withSelfRel());
		
		
		
		return car;
	}

	@Override
	public CarroVo saveCar(CarroVo car) {
		
		var Entity = mapper.map(car, Carro.class);
		
		var cars = mapper.map(repository.save(Entity), CarroVo.class);
		
		cars.add(linkTo(methodOn(ControllerCar.class).findById(cars.getId())).withSelfRel());
		
		return cars;
	}

	@Override
	public CarroVo updateCar(CarroVo car) {
		
		var Entity = mapper.map(car, Carro.class);
		
		var cars= repository.findById(Entity.getId()).orElseThrow();
		
		cars.setName(Entity.getName());
		cars.setMarca(Entity.getMarca());
		cars.setCondicao(Entity.getCondicao());
		cars.setDescricao(Entity.getDescricao());
		cars.setAno(Entity.getAno());
		cars.setPreco(Entity.getPreco());
		
		var savecar = mapper.map(repository.save(cars), CarroVo.class);
		
		savecar.add(linkTo(methodOn(ControllerCar.class).findById(savecar.getId())).withSelfRel());
		
		return savecar;
	}

	@Override
	public void deleteCar(long id) {
		
		var car = repository.findById(id).orElseThrow();
		
		repository.delete(car);
		
	}

	@Override
	public List<CarroVo> findByNameCar(String nome) {
		List<CarroVo> list = new ArrayList<CarroVo>();
		
		for (Carro carro : repository.findByName(nome)) {
			list.add(mapper.map(carro, CarroVo.class));
		}
		
		list
			.stream()
			.forEach(c ->{
				try {
					c.add(linkTo(methodOn(ControllerCar.class).findById(c.getId())).withSelfRel());
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		
		return list;
	}

	
	
	
	
}