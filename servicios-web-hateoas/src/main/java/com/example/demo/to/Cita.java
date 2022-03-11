package com.example.demo.to;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

public class Cita extends RepresentationModel<Cita>{
	
	
	private Integer id;
	private String numero;
	private LocalDateTime fecha;
	
	
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
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
