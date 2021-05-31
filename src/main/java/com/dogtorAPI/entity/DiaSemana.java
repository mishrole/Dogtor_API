package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dia_semana")
public class DiaSemana {

	@Column(name = "codigo_dia_semana")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_dia_semana;
	
	@Column(name = "nombre_dia_semana")
	private String nombre_dia_semana;

	public Integer getCodigo_dia_semana() {
		return codigo_dia_semana;
	}

	public void setCodigo_dia_semana(Integer codigo_dia_semana) {
		this.codigo_dia_semana = codigo_dia_semana;
	}

	public String getNombre_dia_semana() {
		return nombre_dia_semana;
	}

	public void setNombre_dia_semana(String nombre_dia_semana) {
		this.nombre_dia_semana = nombre_dia_semana;
	}
	
	
}