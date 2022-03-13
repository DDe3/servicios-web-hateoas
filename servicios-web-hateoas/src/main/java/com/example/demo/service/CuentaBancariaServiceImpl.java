package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CuentaBancariaRestController;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.to.CuentaBancariaRequest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {
	
	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;

	@Override
	public void insertar(CuentaBancariaRequest cuenta) {
		
		//cuentaBancariaRepository.insertar(cuenta);
		
	}

	@Override
	public void actualizar(CuentaBancariaRequest cuenta) {
		//cuentaBancariaRepository.actualizar(cuenta);
	}

	@Override
	public CuentaBancaria buscar(Integer id) {
		return cuentaBancariaRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		cuentaBancariaRepository.borrar(id);
	}

	@Override
	public List<CuentaBancaria> buscarCuentas(Integer userid) {
		return cuentaBancariaRepository.buscarCuentas(userid);
	}
	
	@Override
	public List<CuentaBancariaRequest> getCuentasBancariasRequest(List<CuentaBancaria> cuentas) {
		List<CuentaBancariaRequest> ret = new ArrayList<>();
		cuentas.forEach( ct -> {
			ret.add(attachLinkCuenta(ct));
		});
		return ret;
	}


	@Override
	public CuentaBancariaRequest getCBRequest(Integer id) {
		CuentaBancaria cb = buscar(id);
		return attachLinkCuenta(cb);
	}

	private CuentaBancariaRequest attachLinkCuenta(CuentaBancaria cuenta) {
		CuentaBancariaRequest cbr = new CuentaBancariaRequest();
		cbr.setId(cuenta.getId());
		cbr.setNumero(cuenta.getNumero());
		cbr.setTipo(cuenta.getTipo());
		Link link = linkTo( methodOn( CuentaBancariaRestController.class ).buscarCuentaFull(cuenta.getId()) ).withRel("Cuenta completa");
		cbr.add(link);
		return cbr;
	}
	
	
	
}
