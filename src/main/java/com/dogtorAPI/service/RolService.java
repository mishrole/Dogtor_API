package com.dogtorAPI.service;

import java.util.List;

import com.dogtorAPI.entity.Rol;

public interface RolService {
	public abstract List<Rol> listaRol();
	public abstract List<Rol> listaRolPorUsuario(Integer codigo_usuario);
}
