package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Enlace;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.entity.Usuario;
import com.dogtorAPI.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplem implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario insertaUsuario(Usuario objUsuario) {
		return repository.save(objUsuario);
	}

	@Override
	public void eliminaUsuario(Integer codigo_usuario) {
		repository.deleteById(codigo_usuario);	
	}

	@Override
	public Optional<Usuario> obtieneUsuarioPorId(Integer codigo_usuario) {
		return repository.obtieneUsuarioPorId(codigo_usuario);
	}

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

	@Override
	public List<Usuario> listaUsuarioPorNombre(String nombre_usuario) {
		return repository.listaUsuarioPorNombre(nombre_usuario+"%");
	}
	
	@Override
	public List<Usuario> listaUsuarioPorRol(Integer codigo_rol_usuario) {
		return repository.listaUsuarioPorRol(codigo_rol_usuario);
	}

	@Override
	public Usuario login(Usuario objUsuario) {
		return repository.login(objUsuario);
	}

	@Override
	public List<Enlace> obtenerEnlacesDeUsuario(Integer codigo_usuario) {
		return repository.obtenerEnlacesDeUsuario(codigo_usuario);
	}

	@Override
	public List<Rol> obtenerRolesDeUsuario(Integer codigo_usuario) {
		return repository.obtenerRolesDeUsuario(codigo_usuario);
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public List<Usuario> obtenerUsuarioPorEmail(String email_usuario) {
		return repository.obtenerUsuarioPorEmail(email_usuario);
	}

	@Override
	public List<Usuario> listaUsuarioPorNombreYRol(String nombre_usuario, Integer codigo_rol_usuario) {
		return repository.listaUsuarioPorNombreYRol(nombre_usuario+"%", codigo_rol_usuario);
	}

}
