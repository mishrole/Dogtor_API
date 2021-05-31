package com.dogtorAPI.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estado_pedido")
public class EstadoPedido {
	
	@Column(name = "codigo_estado_pedido")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_estado_pedido;
	
	@Column(name = "nombre_estado_pedido")
	private String nombre_estado_pedido;

	public Integer getCodigo_estado_pedido() {
		return codigo_estado_pedido;
	}

	public void setCodigo_estado_pedido(Integer codigo_estado_pedido) {
		this.codigo_estado_pedido = codigo_estado_pedido;
	}

	public String getNombre_estado_pedido() {
		return nombre_estado_pedido;
	}

	public void setNombre_estado_pedido(String nombre_estado_pedido) {
		this.nombre_estado_pedido = nombre_estado_pedido;
	}

}
