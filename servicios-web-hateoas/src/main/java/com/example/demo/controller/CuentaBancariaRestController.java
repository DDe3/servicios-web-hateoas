package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.to.CuentaBancariaRequest;

@RestController
@RequestMapping("/ApiCuentaBancaria/V1/cbancarias")
public class CuentaBancariaRestController {
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	/*
	 * Insertar un Cuenta Habiente con el listado de Cuentas 
	 * que posee
	 * 
	 */
	 
	@GetMapping(value = "/{idCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CuentaBancariaRequest> getCuentaBancaria(@PathVariable("idCuenta") Integer idCuenta) {
		return ResponseEntity.ok(cuentaBancariaService.getCBRequest(idCuenta));
	}
	
	@GetMapping(path = "/full/{idCuenta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CuentaBancaria> buscarCuentaFull(@PathVariable("idCuenta") Integer idCuenta) {
		return ResponseEntity.ok(cuentaBancariaService.buscar(idCuenta));
	}
	
	
	
	
	

}
