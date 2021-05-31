package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import com.dogtorAPI.entity.Cita;

public interface CitaService {
	public abstract List<Cita> listaCita();
	public abstract List<Cita> listaCitaPorCodigo(Integer codigo_cita);
	public abstract Cita insertaCita(Cita objCita);
	public abstract List<Cita> listaCitaPorUsuario(Integer codigo_usuario);
	public abstract Optional<Cita> obtienePorId(Integer codigo_cita);
}
