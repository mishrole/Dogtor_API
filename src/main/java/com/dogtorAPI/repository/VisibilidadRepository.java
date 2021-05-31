package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dogtorAPI.entity.Visibilidad;

public interface VisibilidadRepository extends JpaRepository<Visibilidad, Integer> {
	@Query("Select v from Visibilidad v")
	public abstract List<Visibilidad> listaVisibilidad();
}
