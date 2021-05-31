package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Servicio;
import com.dogtorAPI.repository.ServicioRepository;

@Service
public class ServicioServiceImplem implements ServicioService {
	
	@Autowired
	private ServicioRepository repository;

	@Override
	public Servicio insertaServicio(Servicio objServicio) {
		return repository.save(objServicio);
	}

	@Override
	public List<Servicio> listaServicio() {
		return repository.findAll();
	}

	@Override
	public Servicio insertaActualizaServicio(Servicio obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Servicio> obtienePorId(Integer codigo_servicio) {
		return repository.findById(codigo_servicio);
	}

	@Override
	public void eliminaServicio(Integer codigo_servicio) {
		repository.deleteById(codigo_servicio);
	}

	@Override
	public List<Servicio> listaServicioPorNombreLike(String nombre_servicio) {
		return repository.listaServicioPorNombreLike(nombre_servicio + "%");
	}

	@Override
	public List<Servicio> listaServicioPorTipoYEspecialidad(Integer codigo_tipo, Integer codigo_especialidad) {
		return repository.listaServicioPorTipoYEspecialidad(codigo_tipo, codigo_especialidad);
	}
}
