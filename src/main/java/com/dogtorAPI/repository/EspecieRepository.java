package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dogtorAPI.entity.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{

	@Query("Select e from Especie e")
	public abstract List<Especie> listaEspecie();
}
