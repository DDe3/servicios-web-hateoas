package com.example.demo.service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CuentaHabienteRestController;
import com.example.demo.repository.ICuentaHabienteRepository;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.CuentaHabiente;
import com.example.demo.to.CuentaHabienteRequest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class CuentaHabienteServiceImpl implements ICuentaHabienteService {
	
	
	@Autowired
	private ICuentaHabienteRepository cuentaHabienteRepository;
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;

	@Override
	public void insertar(CuentaHabienteRequest usuario) {
		CuentaHabiente cuentaHabiente = new CuentaHabiente();
		cuentaHabiente.setNombre(usuario.getNombre());
		cuentaHabiente.setApellido(usuario.getApellido());
		cuentaHabiente.setCedula(usuario.getCedula());
		cuentaHabiente.setDate(LocalDateTime.now());
		usuario.getCuentas().forEach(c ->
				{
					CuentaBancaria cuenta = new CuentaBancaria();
					cuenta.setNumero(c.getNumero());
					cuenta.setId(c.getId());
					cuenta.setSaldo(BigDecimal.ZERO);
					cuenta.setTipo(c.getTipo());
					cuentaHabiente.addCuenta(cuenta);
				});
		cuentaHabienteRepository.insertar(cuentaHabiente);
		
	}

	@Override
	public void actualizar(CuentaHabienteRequest usuario) {
		//cuentaHabienteRepository.actualizar(usuario);
		
	}

	@Override
	public CuentaHabienteRequest buscar(Integer id) {
		CuentaHabiente cuentaHabiente = cuentaHabienteRepository.buscar(id);
		CuentaHabienteRequest ret = new CuentaHabienteRequest();
		ret.setId(cuentaHabiente.getId());
		ret.setNombre(cuentaHabiente.getNombre());
		ret.setApellido(cuentaHabiente.getApellido());
		ret.setCedula(cuentaHabiente.getCedula());
		return ret;
	}

	@Override
	public void borrar(Integer id) {
		cuentaHabienteRepository.borrar(id);
	}

	
	
	@Override
	public List<CuentaHabienteRequest> buscarTodos() {
		List<CuentaHabiente> usuarios = cuentaHabienteRepository.buscarTodos();
		List<CuentaHabienteRequest> usuariosLink = new ArrayList<>();
		usuarios.forEach( user -> {
			CuentaHabienteRequest ret = new CuentaHabienteRequest();
			ret.setId(user.getId());
			ret.setNombre(user.getNombre());
			ret.setApellido(user.getApellido());
			ret.setCedula(user.getCedula());
			System.out.println(cuentaBancariaService.getCuentasBancariasRequest(user.getCuentas()));
			
			
			Link link = linkTo( methodOn( CuentaHabienteRestController.class ).getCuentaHabiente(user.getId())).withRel("Usuario Completo");
			ret.setCuentas(cuentaBancariaService.getCuentasBancariasRequest(user.getCuentas()));
			ret.add(link);
			usuariosLink.add(ret);
		});
		return usuariosLink;
	}

	@Override
	public CuentaHabiente buscarCuentaHabiente(Integer id) {
		return cuentaHabienteRepository.buscar(id);
	}

	
}
