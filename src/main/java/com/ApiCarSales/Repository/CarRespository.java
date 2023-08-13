package com.ApiCarSales.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ApiCarSales.model.Carro;

import jakarta.transaction.Transactional;

@EnableJpaRepositories
@Transactional
public interface CarRespository extends JpaRepository<Carro, Long>{
	
	@Query("select u from Carro u where u.name = ?1")
	List<Carro> findByName(String name);

}
