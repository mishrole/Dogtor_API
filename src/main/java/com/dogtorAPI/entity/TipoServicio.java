package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo_servicio")
public class TipoServicio {
	
	@Column(name = "codigo_tipo_servicio")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_tipo_servicio;
	
	@Column (name = "nombre_tipo_servicio")
	private String nombre_tipo_servicio;

	public Integer getCodigo_tipo_servicio() {
		return codigo_tipo_servicio;
	}

	public void setCodigo_tipo_servicio(Integer codigo_tipo_servicio) {
		this.codigo_tipo_servicio = codigo_tipo_servicio;
	}

	public String getNombre_tipo_servicio() {
		return nombre_tipo_servicio;
	}

	public void setNombre_tipo_servicio(String nombre_tipo_servicio) {
		this.nombre_tipo_servicio = nombre_tipo_servicio;
	}

}
