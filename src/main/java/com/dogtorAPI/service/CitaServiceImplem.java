package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Cita;
import com.dogtorAPI.repository.CitaRepository;

@Service
public class CitaServiceImplem implements CitaService {
	
	@Autowired
	private CitaRepository repository;

	@Override
	public List<Cita> listaCita() {
		return repository.listaCita();
	}

	@Override
	public List<Cita> listaCitaPorCodigo(Integer codigo_cita) {
		return repository.listaCitaPorCodigo(codigo_cita);
	}

	@Override
	public Cita insertaCita(Cita objCita) {
		return repository.save(objCita);
	}

	@Override
	public List<Cita> listaCitaPorUsuario(Integer codigo_usuario) {
		return repository.listaCitaPorUsuario(codigo_usuario);
	}

	@Override
	public Optional<Cita> obtienePorId(Integer codigo_cita) {
		return repository.findById(codigo_cita);
	}

}
