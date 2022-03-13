package com.example.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "chabiente")
public class CuentaHabiente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_habiente")
	@SequenceGenerator(name = "seq_cuenta_habiente", sequenceName = "seq_cuenta_habiente", allocationSize = 1)
	@Column(name="chab_id")
	private Integer id;
	@Column(name="chab_nombre")
	private String nombre;
	@Column(name="chab_apellido")
	private String apellido;
	@Column(name="chab_cedula")
	private String cedula;
	@Column(name="chab_fnac")
	private LocalDateTime Date;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
	
	
	public void addCuenta(CuentaBancaria cuenta) {
		cuenta.setOwner(this);
		cuentas.add(cuenta);
	}
	
	public void removeCuenta(CuentaBancaria cuenta) {
		cuentas.remove(cuenta);
		cuenta.setOwner(null);
	}
	
	
	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}

	public CuentaHabiente() {}
	
	
	public CuentaHabiente(Integer id, String nombre, String apellido, String cedula, LocalDateTime date) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		Date = date;
	}
	public Integer getId() {
		return id;
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
	public LocalDateTime getDate() {
		return Date;
	}
	public void setDate(LocalDateTime date) {
		Date = date;
	}
	
	
	

}
