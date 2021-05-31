package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Marca;
import com.dogtorAPI.repository.MarcaRepository;

@Service
public class MarcaServiceImplem implements MarcaService {
	
	@Autowired
	private MarcaRepository repository;

	@Override
	public List<Marca> listaMarca() {
		return repository.listaMarca();
	}
	
	
}
