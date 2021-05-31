package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	@Query("Select m from Producto m where m.nombre_producto like :param_producto")
	public abstract List<Producto> listaProductoPorNombre(@Param("param_producto") String nombre_producto);
	
	
}
