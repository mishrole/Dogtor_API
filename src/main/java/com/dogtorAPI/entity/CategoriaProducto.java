package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_categoria_producto")
public class CategoriaProducto {

	@Column(name = "codigo_categoria_producto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_categoria_producto;

	@Column(name = "nombre_categoria_producto")
	private String nombre_categoria_producto;

	public Integer getCodigo_categoria_producto() {
		return codigo_categoria_producto;
	}

	public void setCodigo_categoria_producto(Integer codigo_categoria_producto) {
		this.codigo_categoria_producto = codigo_categoria_producto;
	}

	public String getNombre_categoria_producto() {
		return nombre_categoria_producto;
	}

	public void setNombre_categoria_producto(String nombre_categoria_producto) {
		this.nombre_categoria_producto = nombre_categoria_producto;
	}
	
	
}
