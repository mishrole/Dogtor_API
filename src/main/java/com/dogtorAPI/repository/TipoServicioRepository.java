package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dogtorAPI.entity.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {
	
	@Query("Select ts from TipoServicio ts")
	public abstract List<TipoServicio> listaTipoServicio();
}
