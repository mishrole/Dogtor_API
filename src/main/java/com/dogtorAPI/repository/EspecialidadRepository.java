package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dogtorAPI.entity.Especialidad;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer>{
	
	@Query("Select e from Especialidad e")
	public abstract List<Especialidad> listaEspecialidad();
	
}
