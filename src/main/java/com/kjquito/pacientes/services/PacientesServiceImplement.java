package com.kjquito.pacientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.kjquito.pacientes.dao.PacientesDao;
import com.kjquito.pacientes.entity.PacientesEntity;

@Service
public class PacientesServiceImplement implements PacientesService{

	@Autowired
	private PacientesDao pacientesDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<PacientesEntity> findAll() {
		return (List<PacientesEntity>) pacientesDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public PacientesEntity findById(Long id) {
		return pacientesDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("ID  de paciente incorrecto %s", id)));
	}

	@Override
	public PacientesEntity save(PacientesEntity pacientes) {
		return pacientesDao.save(pacientes);
	}

	@Override
	public void deleteById(Long id) {
		pacientesDao.deleteById(id);
	}

	@Override
	public Iterable<PacientesEntity> findAllById(Iterable<Long> ids) {
		return pacientesDao.findAllById(ids);
	}

}
