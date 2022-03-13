package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.to.CuentaBancariaRequest;

public interface ICuentaBancariaService {
	
	void insertar(CuentaBancariaRequest cuenta);
	void actualizar(CuentaBancariaRequest cuenta);
	CuentaBancaria buscar(Integer id);
	void borrar(Integer id);
	List<CuentaBancaria> buscarCuentas(Integer userid);
	CuentaBancariaRequest getCBRequest(Integer id);
	List<CuentaBancariaRequest> getCuentasBancariasRequest(List<CuentaBancaria> cuentas);

}
