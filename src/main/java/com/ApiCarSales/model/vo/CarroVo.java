package com.ApiCarSales.model.vo;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "marca", "condicao", "descricao", "preco", "ano"})
public class CarroVo extends RepresentationModel<CarroVo> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String name;
	
	private String marca;
	
	private String condicao;
	
	private String descricao;
	
	private double preco;
	
	private String ano;
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
	@Override
	public int hashCode() {
		return Objects.hash(ano, condicao, descricao, id, marca, name, preco);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarroVo other = (CarroVo) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(condicao, other.condicao)
				&& Objects.equals(descricao, other.descricao) && id == other.id && Objects.equals(marca, other.marca)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}
	

}
