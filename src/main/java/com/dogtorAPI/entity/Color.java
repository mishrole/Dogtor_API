package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_color_mascota")
public class Color {

	@Column(name = "codigo_color_mascota")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_color_mascota;

	@Column(name = "nombre_color_mascota")
	private String nombre_color_mascota;

	public Integer getCodigo_color_mascota() {
		return codigo_color_mascota;
	}

	public void setCodigo_color_mascota(Integer codigo_color_mascota) {
		this.codigo_color_mascota = codigo_color_mascota;
	}

	public String getNombre_color_mascota() {
		return nombre_color_mascota;
	}

	public void setNombre_color_mascota(String nombre_color_mascota) {
		this.nombre_color_mascota = nombre_color_mascota;
	}
	
	
}
