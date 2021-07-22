package com.kjquito.pacientes.dao;

import org.springframework.data.repository.CrudRepository;

import com.kjquito.pacientes.entity.PacientesEntity;


public interface PacientesDao extends CrudRepository<PacientesEntity, Long>{

}
