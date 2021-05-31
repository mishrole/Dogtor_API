package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
	
	@Query("Select m from Mascota m where m.nombre_mascota like :param_mascota")
	public abstract List<Mascota> listaMascotaPorNombre(@Param("param_mascota") String nombre_mascota);
	
	@Query("Select m from Mascota m, Visibilidad v where m.codigo_visibilidad = v.codigo_visibilidad and m.codigo_visibilidad = 1 and m.codigo_propietario like :param_propietario")
	public abstract List<Mascota> listaMascotaPorPropietario(@Param("param_propietario") Integer codigo_propietario);
	
	@Query("Select m from Mascota m, Visibilidad v where m.codigo_visibilidad = v.codigo_visibilidad and m.codigo_visibilidad = 1 and m.codigo_propietario like :param_propietario and m.nombre_mascota like :param_mascota")
	public abstract List<Mascota> listaMascotaPorPropietarioYNombre(@Param("param_propietario") Integer codigo_propietario, @Param("param_mascota") String nombre_mascota);
}
