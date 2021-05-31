package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_marca")
public class Marca {

	@Column(name = "codigo_marca")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_marca;

	@Column(name = "nombre_marca")
	private String nombre_marca;

	public Integer getCodigo_marca() {
		return codigo_marca;
	}

	public void setCodigo_marca(Integer codigo_marca) {
		this.codigo_marca = codigo_marca;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
}
