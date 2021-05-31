package com.dogtorAPI.service;

import java.util.List;

import com.dogtorAPI.entity.Raza;

public interface RazaService {
	public abstract List<Raza> listaRaza(Integer especie);
}
