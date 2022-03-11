package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.to.Cita;
import com.example.demo.to.CitaCompleta;
import com.example.demo.to.Direccion;
import com.example.demo.to.Paciente;

@RestController
@RequestMapping("/ApiPacientes/V1")
public class PacienteRestController {

	@GetMapping(value = "/pacientes/{idPaciente}")
	public ResponseEntity<Paciente> obtenerPaciente(@PathVariable(value = "idPaciente") Integer idPaciente) {
		// Simulamos que se consulta de la capa de servicio
		Paciente p = this.obtenerDesdeServicio(idPaciente);
		// "http://localhost:8080/ApiPacientes/V1/2"
		Link myLink = linkTo(PacienteRestController.class).slash(p.getId()).withRel("Informacion adicional");
		Link myLink2 = linkTo(methodOn(PacienteRestController.class).obtenerPaciente(p.getId())).withRel("prueba");
		Link myLink3 = linkTo(methodOn(PacienteRestController.class).obtenerDirecciones(p.getId()))
				.withRel("direcciones");
		p.add(myLink);
		p.add(myLink2);
		p.add(myLink3);

		List<Cita> misCitas = obtenerCitas(p.getId());
		misCitas.forEach(c -> c
				.add(linkTo(methodOn(PacienteRestController.class).obtenerCita(p.getId(), c.getId())).withRel("cita")));
		p.setCitas(misCitas);

		p.setCitas(misCitas);

		return ResponseEntity.ok(p);
	}

	@GetMapping(value = "/pacientes/{idPaciente}/direcciones")
	public ResponseEntity<List<Direccion>> obtenerDirecciones(@PathVariable(value = "idPaciente") Integer idPaciente) {
		return ResponseEntity.ok(obtenerDireccionesServicio(idPaciente));
	}

	@GetMapping(value = "/pacientes/{idPaciente}/citas/{idCita}")
	public ResponseEntity<CitaCompleta> obtenerCita(@PathVariable(value = "idPaciente") Integer idPaciente,
			@PathVariable(value = "idCita") Integer idCita) {
		CitaCompleta myCita = obtenerCitaCompletaServicio(idPaciente, idCita);
		return ResponseEntity.ok(myCita);
	}

	public List<Cita> obtenerCitas(Integer idPaciente) {
		// Consultar las citas del paciente

		Cita c = new Cita();
		c.setNumero("A40");
		c.setId(1);
		c.setFecha(LocalDateTime.now());

		Cita c2 = new Cita();
		c2.setNumero("A40");
		c2.setId(2);
		c2.setFecha(LocalDateTime.now());

		List<Cita> ret = new ArrayList<>();
		ret.add(c);
		ret.add(c2);
		return ret;
	}

	public Cita obtenerCitaServicio(Integer idPaciente, Integer idCita) {
		Cita c = new Cita();
		c.setNumero("A40");
		c.setId(idCita);
		c.setFecha(LocalDateTime.now());
		return c;
	}
	
	
	public CitaCompleta obtenerCitaCompletaServicio(Integer idPaciente, Integer idCita) {
		CitaCompleta c = new CitaCompleta();
		c.setNumero("A40");
		c.setId(idCita);
		c.setFecha(LocalDateTime.now());
		c.setDoctor("Doctor"+idCita);
		return c;
	}
	

	public Paciente obtenerDesdeServicio(Integer idPaciente) {
		Paciente pac = new Paciente();
		pac.setId(idPaciente);
		pac.setNombre("Leonardo");
		pac.setEdad(32);
		return pac;
	}

	public List<Direccion> obtenerDireccionesServicio(Integer idPaciente) {
		Direccion d1 = new Direccion();
		Direccion d2 = new Direccion();
		d1.setId(1);
		d2.setId(2);
		d1.setCalle("Maldonado");
		d2.setCalle("Teniente Hugo Ortiz");
		d1.setNumero("S10-259");
		d2.setNumero("S10-250");

		List<Direccion> misDirecciones = new ArrayList<>();
		misDirecciones.add(d1);
		misDirecciones.add(d2);
		return misDirecciones;
	}
}
