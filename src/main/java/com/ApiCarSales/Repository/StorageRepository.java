package com.ApiCarSales.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ApiCarSales.model.ImageData;


@EnableJpaRepositories
public interface StorageRepository extends JpaRepository<ImageData, Long>{

	
	Optional<ImageData> findByName(String fileName);
}

