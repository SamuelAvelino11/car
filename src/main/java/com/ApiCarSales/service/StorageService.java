package com.ApiCarSales.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ApiCarSales.Repository.StorageRepository;
import com.ApiCarSales.model.ImageData;
import com.ApiCarSales.util.ImageUtils;


@Service
public class StorageService {
	
	@Autowired
	private StorageRepository repository;
	
	@Autowired
	private CarService2 serv;
	
	public String uploadImage(MultipartFile file, Long id) throws IOException {
		
		
		ImageData imageData = new ImageData();
		
		var carro = serv.findById(id);
		
		imageData.setCar(carro);
		
		imageData = repository.save(ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		
		
		
		if (imageData!=null) {
			return "file uploaded successfully: " + file.getOriginalFilename();
		}
		return null;
		
	}
	
	public byte[] downloadImage(String fileName) {
		
		Optional<ImageData> dbImageData =  repository.findByName(fileName);
		
		byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
		
		return images;
	}

}