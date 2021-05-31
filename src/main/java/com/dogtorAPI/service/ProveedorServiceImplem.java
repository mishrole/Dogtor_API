package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Proveedor;
import com.dogtorAPI.repository.ProveedorRepository;

@Service
public class ProveedorServiceImplem implements ProveedorService {
	
	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<Proveedor> listaProveedor() {
		return repository.listaProveedor();
	}
}
