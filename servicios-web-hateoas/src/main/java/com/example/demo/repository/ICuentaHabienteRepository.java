package com.example.demo.repository;


import java.util.List;

import com.example.demo.repository.modelo.CuentaHabiente;


public interface ICuentaHabienteRepository {
	
	
	void insertar(CuentaHabiente usuario);
	void actualizar(CuentaHabiente usuario);
	CuentaHabiente buscar(Integer id);
	void borrar(Integer id);
	List<CuentaHabiente> buscarTodos();

}
