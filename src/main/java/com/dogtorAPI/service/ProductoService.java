package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import com.dogtorAPI.entity.Producto;

public interface ProductoService {
	public abstract List<Producto> listaProducto();
	public abstract List<Producto> listaProductoPorNombre(String nombre_producto);
	public abstract Producto insertaProducto(Producto objProducto);
	public abstract void eliminaProducto(Integer codigo_producto);
	public abstract Optional<Producto> obtienePorId(Integer codigo_producto);

	
}
