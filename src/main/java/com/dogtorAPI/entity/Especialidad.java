package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_especialidad")
public class Especialidad {

	@Column(name = "codigo_especialidad")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_especialidad;

	@Column(name = "nombre_especialidad")
	private String nombre_especialidad;

	public Integer getCodigo_especialidad() {
		return codigo_especialidad;
	}

	public void setCodigo_especialidad(Integer codigo_especialidad) {
		this.codigo_especialidad = codigo_especialidad;
	}

	public String getNombre_especialidad() {
		return nombre_especialidad;
	}

	public void setNombre_especialidad(String nombre_especialidad) {
		this.nombre_especialidad = nombre_especialidad;
	}
}
