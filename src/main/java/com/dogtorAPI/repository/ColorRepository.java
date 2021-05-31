package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dogtorAPI.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{

	@Query("Select c from Color c")
	public abstract List<Color> listaColor();
	
}
