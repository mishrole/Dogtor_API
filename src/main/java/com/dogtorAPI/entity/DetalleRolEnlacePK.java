package com.dogtorAPI.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class DetalleRolEnlacePK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "codigo_rol_usuario")
	private Integer codigo_rol_usuario;
	
	@Column(name = "codigo_enlace")
	private Integer codigo_enlace;

	public Integer getCodigo_rol_usuario() {
		return codigo_rol_usuario;
	}

	public void setCodigo_rol_usuario(Integer codigo_rol_usuario) {
		this.codigo_rol_usuario = codigo_rol_usuario;
	}

	public Integer getCodigo_enlace() {
		return codigo_enlace;
	}

	public void setCodigo_enlace(Integer codigo_enlace) {
		this.codigo_enlace = codigo_enlace;
	}
	
}
