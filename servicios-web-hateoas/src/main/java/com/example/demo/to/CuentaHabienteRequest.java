package com.example.demo.to;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;


public class CuentaHabienteRequest extends RepresentationModel<CuentaHabienteRequest> {

	private Integer id;
	private String nombre;
	private String apellido;
	private String cedula;
	private List<CuentaBancariaRequest> cuentas;
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<CuentaBancariaRequest> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<CuentaBancariaRequest> cuentas) {
		this.cuentas = cuentas;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", cuentas : " + cuentas ;
	}
	
	
	
}
