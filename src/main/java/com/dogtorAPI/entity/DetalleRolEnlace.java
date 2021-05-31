package com.dogtorAPI.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "tb_detalle_rol_enlace")
public class DetalleRolEnlace {
	
	@EmbeddedId
	private DetalleRolEnlacePK objDetalleRolEnlacePK;
	
	@ManyToOne
	@JoinColumn(name = "codigo_rol_usuario", nullable = false, insertable = false, updatable = false)
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "codigo_enlace",  nullable = false, insertable = false, updatable = false)
	private Enlace enlace;

	public DetalleRolEnlacePK getObjDetalleRolEnlacePK() {
		return objDetalleRolEnlacePK;
	}

	public void setObjDetalleRolEnlacePK(DetalleRolEnlacePK objDetalleRolEnlacePK) {
		this.objDetalleRolEnlacePK = objDetalleRolEnlacePK;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}
	
}
