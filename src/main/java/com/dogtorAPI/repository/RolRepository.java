package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	@Query("Select r from Rol r")
	public abstract List<Rol> listaRol();
	
	@Query("Select r from Rol r, DetalleUsuarioRol dru where r.codigo_rol_usuario = dru.rol.codigo_rol_usuario and dru.usuario.codigo_usuario = :param_usuario")
	public abstract List<Rol> listaRolPorUsuario(@Param("param_usuario") Integer codigo_usuario);
	
}
