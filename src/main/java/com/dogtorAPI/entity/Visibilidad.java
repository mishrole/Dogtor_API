package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_visibilidad")
public class Visibilidad {
	
	@Column(name = "codigo_visibilidad")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_visibilidad;
	
	@Column(name = "nombre_visibilidad")
	private String nombre_visibilidad;

	public Integer getCodigo_visibilidad() {
		return codigo_visibilidad;
	}

	public void setCodigo_visibilidad(Integer codigo_visibilidad) {
		this.codigo_visibilidad = codigo_visibilidad;
	}

	public String getNombre_visibilidad() {
		return nombre_visibilidad;
	}

	public void setNombre_visibilidad(String nombre_visibilidad) {
		this.nombre_visibilidad = nombre_visibilidad;
	}

}
