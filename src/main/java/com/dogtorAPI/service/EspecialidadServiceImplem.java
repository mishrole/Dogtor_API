package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Especialidad;
import com.dogtorAPI.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImplem implements EspecialidadService {
	
	@Autowired
	private EspecialidadRepository repository;
	
	@Override
	public List<Especialidad> listaEspecialidad() {
		return repository.listaEspecialidad();
	}

}
