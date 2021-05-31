package com.dogtorAPI.service;
import com.dogtorAPI.entity.Enlace;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.entity.Usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
	public abstract List<Usuario> listaUsuario();
	public abstract void eliminaUsuario(Integer codigo_usuario);
	public abstract Optional<Usuario> obtieneUsuarioPorId(Integer codigo_usuario);
	public abstract Usuario insertaUsuario(Usuario objUsuario);
	
	public abstract List<Usuario> listaUsuarioPorNombre(String nombre_usuario);
	public abstract List<Usuario> listaUsuarioPorRol(Integer codigo_rol_usuario);
	public abstract List<Usuario> listaUsuarioPorNombreYRol(String nombre_usuario, Integer codigo_rol_usuario);
	
	public abstract Usuario login(Usuario objUsuario);
	public abstract List<Enlace> obtenerEnlacesDeUsuario(Integer codigo_usuario);
	public abstract List<Rol> obtenerRolesDeUsuario(Integer codigo_usuario);
	public Page<Usuario> findAll(Pageable pageable);
	
	public abstract List<Usuario> obtenerUsuarioPorEmail(String email_usuario);
}
