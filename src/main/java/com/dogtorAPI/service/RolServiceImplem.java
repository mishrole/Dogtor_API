package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.repository.RolRepository;

@Service
public class RolServiceImplem implements RolService {
	
	@Autowired
	private RolRepository repository;
	
	@Override
	public List<Rol> listaRol() {
		return repository.listaRol();
	}
	
	
	@Override
	public List<Rol> listaRolPorUsuario(Integer codigo_usuario) {
		return repository.listaRolPorUsuario(codigo_usuario);
	}
	
}
