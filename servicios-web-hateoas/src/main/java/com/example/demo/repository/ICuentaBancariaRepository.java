package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	
	void insertar(CuentaBancaria cuenta);
	void actualizar(CuentaBancaria cuenta);
	CuentaBancaria buscar(Integer id);
	void borrar(Integer id);
	List<CuentaBancaria> buscarCuentas(Integer userid);
	

}
