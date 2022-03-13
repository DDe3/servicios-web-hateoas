package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "cbancaria")
public class CuentaBancaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta_bancaria")
	@SequenceGenerator(name = "seq_cuenta_bancaria", sequenceName = "seq_cuenta_bancaria", allocationSize = 1)
	@Column(name = "cban_id")
	private Integer id;
	
	@Column(name = "cban_numero")
	private String numero;
	@Column(name = "cban_tipo")
	private String tipo;
	@Column(name = "cban_saldo")
	private BigDecimal saldo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chab_id")
	@JsonIgnore
	private CuentaHabiente owner;

	public CuentaBancaria(Integer id, String numero, String tipo, BigDecimal saldo, CuentaHabiente owner) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = saldo;
		this.owner = owner;
	}

	public CuentaBancaria() {}
	
	public Integer getId() {
		return this.id;
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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public CuentaHabiente getOwner() {
		return owner;
	}

	public void setOwner(CuentaHabiente owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "id=" + id + ", numero=" + numero + ", Tipo=" + tipo + ", owner="
				+ owner + "]";
	}
	
	
	
	
	
}
