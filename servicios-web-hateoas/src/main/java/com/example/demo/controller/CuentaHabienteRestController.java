package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.CuentaHabiente;
import com.example.demo.service.ICuentaHabienteService;
import com.example.demo.to.CuentaHabienteRequest;

@RestController
@RequestMapping("/ApiCuentaHabiente/V1/chabientes")
public class CuentaHabienteRestController {
	
	@Autowired
	private ICuentaHabienteService cuentaService;
	
	/*
	 * Insertar un Cuenta Habiente con el listado de Cuentas 
	 * que posee
	 * 
	 */
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertarCuentaHabiente(@RequestBody CuentaHabienteRequest cuentaHabienteRequest) {
		cuentaService.insertar(cuentaHabienteRequest);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CuentaHabienteRequest>> buscarCuentaHabientes() {
		
		List<CuentaHabienteRequest> chabientes = cuentaService.buscarTodos();
		
		//List<CuentaBancaria> cuentaBancaria = chabientes.get(0).getCuentas();

		return ResponseEntity.ok(chabientes);
	}
	
	
	
	
	@GetMapping(path = "/full/{idCuentaHabiente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CuentaHabiente> getCuentaHabiente(@PathVariable(value = "idCuentaHabiente") Integer idCuentaHabiente) {
		return ResponseEntity.ok(cuentaService.buscarCuentaHabiente(idCuentaHabiente));
	}
	
	
	

}
