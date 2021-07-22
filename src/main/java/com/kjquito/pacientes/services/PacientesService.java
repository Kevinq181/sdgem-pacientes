package com.kjquito.pacientes.services;

import java.util.List;

import com.kjquito.pacientes.entity.PacientesEntity;



public interface PacientesService {
	public List<PacientesEntity> findAll();

	public PacientesEntity findById(Long id);

	public PacientesEntity save(PacientesEntity pacientes);

	public void deleteById(Long id);
	
	public Iterable<PacientesEntity> findAllById(Iterable<Long> ids);

}
