package com.kjquito.pacientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kjquito.pacientes.entity.PacientesEntity;
import com.kjquito.pacientes.services.PacientesService;



@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
public class PacientesController {
	
	@Autowired
	private PacientesService pacientesService;
	
	@CrossOrigin
	@GetMapping("/paciente")
	@ResponseStatus(HttpStatus.OK)
	public List<PacientesEntity> getAll() {
		return pacientesService.findAll();
	}
	
	@GetMapping("/pacienteSolicitud")
	public ResponseEntity<?> obtenerUsuarioPorMedico(@RequestParam List<Long> ids){
		return ResponseEntity.ok(pacientesService.findAllById(ids));
	}
	
	
	@GetMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PacientesEntity getById(@PathVariable Long id) {
		return pacientesService.findById(id);
	}

	@PostMapping("/paciente")
	@ResponseStatus(HttpStatus.CREATED)
	public PacientesEntity save(@RequestBody PacientesEntity pacientes) {
		return pacientesService.save(pacientes);
	}

	@PutMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PacientesEntity updateById(@RequestBody PacientesEntity pacientes, @PathVariable Long id) {
		PacientesEntity institucionDB = pacientesService.findById(id);
		institucionDB.setCedula(pacientes.getCedula());
		institucionDB.setNombres(pacientes.getNombres());
		institucionDB.setApellidos(pacientes.getApellidos());
		institucionDB.setFechaNacimiento(pacientes.getFechaNacimiento());
		institucionDB.setTelefono(pacientes.getTelefono());
		institucionDB.setDireccion(pacientes.getDireccion());
		institucionDB.setGenero(pacientes.getGenero());
		return pacientesService.save(institucionDB);
	}

	@DeleteMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		pacientesService.deleteById(id);
	}

}
