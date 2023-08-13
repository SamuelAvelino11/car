package com.ApiCarSales.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String name;
	
	@Column(name = "marca", nullable = false, length = 50)
	private String marca;
	
	@Column(name = "condicao", nullable = false, length = 30)
	private String condicao;
	
	@Column(name = "descricao", nullable = false, length = 255)
	private String descricao;
	
	@Column(name = "preco", nullable = false)
	private double preco;
	
	@Column(name = "ano", nullable = true)
	private String ano;
	
	@JoinColumn(name = "car_id")
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	private List<ImageData> images;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<ImageData> getImages() {
		return images;
	}

	public void setImages(List<ImageData> images) {
		this.images = images;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, condicao, descricao, id, images, marca, name, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(condicao, other.condicao)
				&& Objects.equals(descricao, other.descricao) && id == other.id && Objects.equals(images, other.images)
				&& Objects.equals(marca, other.marca) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
	
	
}
