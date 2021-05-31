package com.dogtorAPI.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_detalle_usuario_rol")
public class DetalleUsuarioRol {
	
	@EmbeddedId
	private DetalleUsuarioRolPK objDetalleUsuarioRolPK;
	
	@ManyToOne
	@JoinColumn(name = "codigo_usuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_rol_usuario", nullable = false, insertable = false, updatable = false)
	private Rol rol;
	
	public DetalleUsuarioRolPK getObjDetalleUsuarioRolPK() {
		return objDetalleUsuarioRolPK;
	}

	public void setObjDetalleUsuarioRolPK(DetalleUsuarioRolPK objDetalleUsuarioRolPK) {
		this.objDetalleUsuarioRolPK = objDetalleUsuarioRolPK;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
