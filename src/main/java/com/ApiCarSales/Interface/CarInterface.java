package com.ApiCarSales.Interface;

import java.util.List;

import com.ApiCarSales.model.vo.CarroVo;


public interface CarInterface {


	public List<CarroVo> findAll();
	
	public CarroVo findById(long id);
	
	public List<CarroVo> findByNameCar(String nome);
	
	public CarroVo saveCar(CarroVo car);
	
	public CarroVo updateCar(CarroVo car);
	
	public void deleteCar(long id);


	
}