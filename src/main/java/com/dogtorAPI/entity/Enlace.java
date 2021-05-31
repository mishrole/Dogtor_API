package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enlace")
public class Enlace {
	
	@Column(name = "codigo_enlace")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_enlace;
	
	@Column(name = "descripcion_enlace")
	private String descripcion_enlace;
	
	@Column(name = "ruta_enlace")
	private String ruta_enlace;
	
	@Column(name = "icono_enlace")
	private String icono_enlace;

	public Integer getCodigo_enlace() {
		return codigo_enlace;
	}

	public void setCodigo_enlace(Integer codigo_enlace) {
		this.codigo_enlace = codigo_enlace;
	}

	public String getDescripcion_enlace() {
		return descripcion_enlace;
	}

	public void setDescripcion_enlace(String descripcion_enlace) {
		this.descripcion_enlace = descripcion_enlace;
	}

	public String getRuta_enlace() {
		return ruta_enlace;
	}

	public void setRuta_enlace(String ruta_enlace) {
		this.ruta_enlace = ruta_enlace;
	}

	public String getIcono_enlace() {
		return icono_enlace;
	}

	public void setIcono_enlace(String icono_enlace) {
		this.icono_enlace = icono_enlace;
	}
	
}
