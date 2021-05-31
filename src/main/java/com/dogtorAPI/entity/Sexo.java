package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_sexo_mascota")
public class Sexo {

	@Column(name = "codigo_sexo_mascota")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_sexo_mascota;

	@Column(name = "nombre_sexo_mascota")
	private String nombre_sexo_mascota;

	public Integer getCodigo_sexo_mascota() {
		return codigo_sexo_mascota;
	}

	public void setCodigo_sexo_mascota(Integer codigo_sexo_mascota) {
		this.codigo_sexo_mascota = codigo_sexo_mascota;
	}

	public String getNombre_sexo_mascota() {
		return nombre_sexo_mascota;
	}

	public void setNombre_sexo_mascota(String nombre_sexo_mascota) {
		this.nombre_sexo_mascota = nombre_sexo_mascota;
	}
	
	
}
