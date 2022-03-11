package com.example.demo.to;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

public class Paciente extends RepresentationModel<Paciente> {
	
	private Integer id;
	
	private String nombre;
	private Integer edad;
	
	private List<Cita> citas;
	
	
	public List<Cita> getCitas() {
		return citas;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	

}
