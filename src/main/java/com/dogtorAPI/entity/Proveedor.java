package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_proveedor")
public class Proveedor {

	@Column(name = "codigo_proveedor")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_proveedor;

	@Column(name = "nombre_proveedor")
	private String nombre_proveedor;

	public Integer getCodigo_proveedor() {
		return codigo_proveedor;
	}

	public void setCodigo_proveedor(Integer codigo_proveedor) {
		this.codigo_proveedor = codigo_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

}
