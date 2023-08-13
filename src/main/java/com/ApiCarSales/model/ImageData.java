package com.ApiCarSales.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "ImageData")
@Builder
public class ImageData implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String type;
	
	@Lob
	@Column(name = "imagedata", length = 1000)
	private byte[] imageData;
	
	@ManyToMany
	@JoinColumn(name = "car_id")
	private Carro car;

	public ImageData() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public Carro getCar() {
		return car;
	}

	public void setCar(Carro car) {
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imageData);
		result = prime * result + Objects.hash(car, id, name, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImageData other = (ImageData) obj;
		return Objects.equals(car, other.car) && Objects.equals(id, other.id)
				&& Arrays.equals(imageData, other.imageData) && Objects.equals(name, other.name)
				&& Objects.equals(type, other.type);
	}

	public ImageData(Long id, String name, String type, byte[] imageData, Carro car) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
		this.car = car;
	}

	
}
