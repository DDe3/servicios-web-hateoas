package com.example.demo.to;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

public class CuentaBancariaRequest extends RepresentationModel<CuentaBancariaRequest> {
	
	private Integer id;
	private String numero;
	private String tipo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", tipo=" + tipo + "]";
	}

	
	
	
	
}
