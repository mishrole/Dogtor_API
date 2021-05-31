package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estado_cita")
public class EstadoCita {
	
	@Column(name = "codigo_estado_cita")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_estado_cita;
	
	@Column(name = "nombre_estado_cita")
	private String nombre_estado_cita;

	public Integer getCodigo_estado_cita() {
		return codigo_estado_cita;
	}

	public void setCodigo_estado_cita(Integer codigo_estado_cita) {
		this.codigo_estado_cita = codigo_estado_cita;
	}

	public String getNombre_estado_cita() {
		return nombre_estado_cita;
	}

	public void setNombre_estado_cita(String nombre_estado_cita) {
		this.nombre_estado_cita = nombre_estado_cita;
	}

}
