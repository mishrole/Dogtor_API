package com.dogtorAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Enlace;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	/* CONSULTA PARA CRUD */
	
	@Query("Select u from Usuario u, Distrito d, Visibilidad v where d.codigo_distrito = u.distrito.codigo_distrito and v.codigo_visibilidad = u.visibilidad.codigo_visibilidad and concat(u.nombre_usuario, ' ', u.apellido_usuario) like :param_usuario")
	public abstract List<Usuario> listaUsuarioPorNombre(@Param("param_usuario") String nombre_usuario);

	@Query("Select u from Usuario u, DetalleUsuarioRol dur, Rol r where dur.usuario.codigo_usuario = u.codigo_usuario and "+
	"r.codigo_rol_usuario = dur.rol.codigo_rol_usuario and dur.rol.codigo_rol_usuario = :param_rol")
	public abstract List<Usuario> listaUsuarioPorRol(@Param("param_rol") Integer codigo_rol_usuario);
	
	@Query("Select u from Usuario u, DetalleUsuarioRol dur, Rol r where dur.usuario.codigo_usuario = u.codigo_usuario and "+
			"r.codigo_rol_usuario = dur.rol.codigo_rol_usuario and concat(u.nombre_usuario, ' ', u.apellido_usuario) like :param_usuario and dur.rol.codigo_rol_usuario = :param_rol")
	public abstract List<Usuario> listaUsuarioPorNombreYRol(@Param("param_usuario") String nombre_usuario, @Param("param_rol") Integer codigo_rol_usuario);
	
	/* LOGIN DE USUARIO, ROLES, y ENLACES */
	
	@Query("Select u from Usuario u where u.email_usuario = :#{#usu.email_usuario} and u.contrasena_usuario = :#{#usu.contrasena_usuario}")
	public abstract Usuario login(@Param(value = "usu") Usuario objUsuario);
	
	@Query("Select r from Rol r, DetalleUsuarioRol dur where " +
	"r.codigo_rol_usuario = dur.rol.codigo_rol_usuario and " +
	"dur.usuario.codigo_usuario = :param_usuario")
	public abstract List<Rol> obtenerRolesDeUsuario(@Param("param_usuario") Integer codigo_usuario);
	
	@Query("Select e from Enlace e, DetalleRolEnlace dre, Rol r, DetalleUsuarioRol dur where " +
	" e.codigo_enlace = dre.enlace.codigo_enlace and " + 
	" dre.rol.codigo_rol_usuario = r.codigo_rol_usuario and " +
	" r.codigo_rol_usuario = dur.rol.codigo_rol_usuario and " + 
	" dur.usuario.codigo_usuario = :param_usuario")
	public abstract List<Enlace> obtenerEnlacesDeUsuario(@Param("param_usuario") Integer codigo_usuario);
	
	@Query("Select u from Usuario u where u.email_usuario = :param_email")
	public abstract List<Usuario> obtenerUsuarioPorEmail(@Param("param_email") String email_usuario);
	
	@Query("Select u from Usuario u where u.codigo_usuario like :param_usuario")
	public abstract Optional<Usuario> obtieneUsuarioPorId(@Param("param_usuario") Integer codigo_usuario);
	
	public Page<Usuario> findAll(Pageable pageable);
	
	
}
