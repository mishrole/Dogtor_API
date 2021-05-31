package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
	@Query("Select s from Servicio s where s.nombre_servicio like :fil")
	public abstract List<Servicio> listaServicioPorNombreLike(@Param("fil") String nombre_servicio);
	
	@Query("Select s from Servicio s where s.codigo_tipo_servicio like :param_tipo and s.codigo_especialidad like :param_especialidad")
	public abstract List<Servicio> listaServicioPorTipoYEspecialidad(@Param("param_tipo") Integer codigo_tipo, @Param("param_especialidad") Integer codigo_especialidad);
}
