package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import com.dogtorAPI.entity.Servicio;

public interface ServicioService {
	public abstract Servicio insertaServicio(Servicio objServicio);
	public abstract List<Servicio> listaServicio();
	public abstract Servicio insertaActualizaServicio(Servicio obj);
	public abstract Optional<Servicio> obtienePorId(Integer codigo_servicio);
	public abstract void eliminaServicio(Integer codigo_servicio);
	public abstract List<Servicio> listaServicioPorNombreLike(String nombre_servicio);
	public abstract List<Servicio> listaServicioPorTipoYEspecialidad(Integer codigo_tipo, Integer codigo_especialidad);
}
