package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_especie_mascota")
public class Especie {

	@Column(name = "codigo_especie_mascota")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_especie_mascota;

	@Column(name = "nombre_especie_mascota")
	private String nombre_especie_mascota;

	public Integer getCodigo_especie_mascota() {
		return codigo_especie_mascota;
	}

	public void setCodigo_especie_mascota(Integer codigo_especie_mascota) {
		this.codigo_especie_mascota = codigo_especie_mascota;
	}

	public String getNombre_especie_mascota() {
		return nombre_especie_mascota;
	}

	public void setNombre_especie_mascota(String nombre_especie_mascota) {
		this.nombre_especie_mascota = nombre_especie_mascota;
	}
	
	
}
