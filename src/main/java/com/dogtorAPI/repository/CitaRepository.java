package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer>{
	
	@Query("Select c from Cita c, Servicio s, Usuario u, Mascota m, EstadoCita ec where c.servicio.codigo_servicio = s.codigo_servicio and c.usuario.codigo_usuario = u.codigo_usuario and c.mascota.codigo_mascota = m.codigo_mascota and c.estado.codigo_estado_cita = ec.codigo_estado_cita and c.codigo_cita like :param_cita")
	public abstract List<Cita> listaCitaPorCodigo(@Param("param_cita") Integer codigo_cita);
	
	@Query("Select c from Cita c, Servicio s, Usuario u, Mascota m, EstadoCita ec where c.servicio.codigo_servicio = s.codigo_servicio and c.usuario.codigo_usuario = u.codigo_usuario and c.mascota.codigo_mascota = m.codigo_mascota and c.estado.codigo_estado_cita = ec.codigo_estado_cita")
	public abstract List<Cita> listaCita();
	
	@Query("Select c from Cita c, Servicio s, Usuario u, Mascota m, EstadoCita ec where c.servicio.codigo_servicio = s.codigo_servicio and c.usuario.codigo_usuario = u.codigo_usuario and c.mascota.codigo_mascota = m.codigo_mascota and c.estado.codigo_estado_cita = ec.codigo_estado_cita and c.codigo_propietario like :param_usuario")
	public abstract List<Cita> listaCitaPorUsuario(@Param("param_usuario") Integer codigo_usuario);
	
}
