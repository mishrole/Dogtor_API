package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dogtorAPI.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {
	
	@Query("Select m from Marca m")
	public abstract List<Marca> listaMarca();
}
