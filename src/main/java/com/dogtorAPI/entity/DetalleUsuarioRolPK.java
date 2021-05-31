package com.dogtorAPI.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleUsuarioRolPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "codigo_usuario")
	private Integer codigo_usuario;
	
	@Column(name = "codigo_rol_usuario")
	private Integer codigo_rol_usuario;

	public Integer getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(Integer codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

	public Integer getCodigo_rol_usuario() {
		return codigo_rol_usuario;
	}

	public void setCodigo_rol_usuario(Integer codigo_rol_usuario) {
		this.codigo_rol_usuario = codigo_rol_usuario;
	}
	
}
