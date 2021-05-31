package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "tb_distrito")
public class Distrito {
	
	@Column(name = "codigo_distrito")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_distrito;
	
	@Column(name = "nombre_distrito")
	private String nombre_distrito;
	
	public Integer getCodigo_distrito() {
		return codigo_distrito;
	}

	public void setCodigo_distrito(Integer codigo_distrito) {
		this.codigo_distrito = codigo_distrito;
	}

	public String getNombre_distrito() {
		return nombre_distrito;
	}

	public void setNombre_distrito(String nombre_distrito) {
		this.nombre_distrito = nombre_distrito;
	}

}
