package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Mascota;
import com.dogtorAPI.repository.MascotaRepository;

@Service
public class MascotaServiceImplem implements MascotaService {
	
	@Autowired
	private MascotaRepository repository;

	@Override
	public Mascota insertaMascota(Mascota objMascota) {
		return repository.save(objMascota);
	}

	@Override
	public List<Mascota> listaMascotaPorNombre(String nombre_mascota) {
		return repository.listaMascotaPorNombre(nombre_mascota+"%");
	}

	@Override
	public List<Mascota> listaMascota() {
		return repository.findAll();
	}

	@Override
	public void eliminaMascota(Integer codigo_mascota) {
		repository.deleteById(codigo_mascota);
	}

	@Override
	public Optional<Mascota> obtienePorId(Integer codigo_mascota) {
		return repository.findById(codigo_mascota);
	}

	@Override
	public List<Mascota> listaMascotaPorPropietario(Integer codigo_propietario) {
		return repository.listaMascotaPorPropietario(codigo_propietario);
	}

	@Override
	public List<Mascota> listaMascotaPorPropietarioYNombre(Integer codigo_propietario, String nombre_mascota) {
		return repository.listaMascotaPorPropietarioYNombre(codigo_propietario, nombre_mascota+"%");
	}
	
}
