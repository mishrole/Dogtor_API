package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_rol_usuario")
public class Rol {
	
	@Column(name = "codigo_rol_usuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_rol_usuario;
	
	@Column(name = "nombre_rol_usuario")
	private String nombre_rol_usuario;

	public Integer getCodigo_rol_usuario() {
		return codigo_rol_usuario;
	}

	public void setCodigo_rol_usuario(Integer codigo_rol_usuario) {
		this.codigo_rol_usuario = codigo_rol_usuario;
	}

	public String getNombre_rol_usuario() {
		return nombre_rol_usuario;
	}

	public void setNombre_rol_usuario(String nombre_rol_usuario) {
		this.nombre_rol_usuario = nombre_rol_usuario;
	}
	
}
