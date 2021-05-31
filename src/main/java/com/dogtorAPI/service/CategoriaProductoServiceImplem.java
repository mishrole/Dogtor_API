package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.CategoriaProducto;
import com.dogtorAPI.repository.CategoriaProductoRepository;

@Service
public class CategoriaProductoServiceImplem implements CategoriaProductoService {
	
	@Autowired
	private CategoriaProductoRepository repository;

	@Override
	public List<CategoriaProducto> listaCategoriaProducto() {
		return repository.listaCategoriaProducto();
	}
	
	
}
