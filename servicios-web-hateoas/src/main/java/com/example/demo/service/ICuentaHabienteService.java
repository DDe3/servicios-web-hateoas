package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.CuentaHabiente;
import com.example.demo.to.CuentaHabienteRequest;

public interface ICuentaHabienteService {
	
	void insertar(CuentaHabienteRequest usuario);
	void actualizar(CuentaHabienteRequest usuario);
	CuentaHabienteRequest buscar(Integer id);
	CuentaHabiente buscarCuentaHabiente(Integer id);
	void borrar(Integer id);
	List<CuentaHabienteRequest> buscarTodos();

}
