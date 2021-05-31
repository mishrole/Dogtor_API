package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Producto;
import com.dogtorAPI.repository.ProductoRepository;

@Service
public class ProductoServiceImplem implements ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Producto insertaProducto(Producto objProducto) {
		return repository.save(objProducto);
	}

	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public List<Producto> listaProductoPorNombre(String nombre_producto) {
		return repository.listaProductoPorNombre(nombre_producto+"%");
	}

	@Override
	public void eliminaProducto(Integer codigo_producto) {
		repository.deleteById(codigo_producto);
		
	}

	@Override
	public Optional<Producto> obtienePorId(Integer codigo_producto) {
		return repository.findById(codigo_producto);
	}
	
}
