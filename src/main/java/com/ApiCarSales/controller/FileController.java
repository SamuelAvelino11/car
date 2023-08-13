package com.ApiCarSales.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ApiCarSales.service.StorageService;


@RestController
@RequestMapping(value = "/image")
public class FileController {
	
	@Autowired
	private StorageService service;

	@PostMapping("/{id}")
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file,
			@PathVariable("id") Long id) throws IOException{
		
		String uploadImage = service.uploadImage(file, id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
		
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName){
		
		byte[] imageData = service.downloadImage(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}
	
	/**@Query("select u from ImageData u where u.fileName = ?1")
	Optional<ImageData> findByName(String fileName); **/
	
}

