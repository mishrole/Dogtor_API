package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Sexo;
import com.dogtorAPI.repository.SexoRepository;

@Service
public class SexoServiceImplem implements SexoService {
	
	@Autowired
	private SexoRepository repository;
	
	@Override
	public List<Sexo> listaSexo() {
		return repository.listaSexo();
	}
	
}
