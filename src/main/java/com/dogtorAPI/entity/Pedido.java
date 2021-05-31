package com.dogtorAPI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {
	
	@Column(name = "codigo_pedido")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_pedido;
	
	@Column(name = "codigo_cliente")
	private Integer codigo_cliente;
	
	@Column(name = "fecha_solicitud_pedido")
	private Date fecha_solicitud_pedido;
	
	@Column(name = "fecha_entrega_pedido")
	private String fecha_entrega_pedido;
	
	@Column(name = "monto_pedido")
	private Double monto_pedido;
	
	@Column(name = "codigo_repartidor")
	private Integer codigo_repartidor;
	
	@Column(name = "codigo_estado_pedido")
	private Integer codigo_estado_pedido;
	
	@ManyToOne
	@JoinColumn(name = "codigo_cliente", insertable = false, updatable = false, nullable = false)
	private Usuario usuarioCliente;
	
	@ManyToOne
	@JoinColumn(name = "codigo_repartidor", insertable = false, updatable = false, nullable = false)
	private Usuario usuarioRepartidor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_estado_pedido", insertable = false, updatable = false, nullable = false)
	private EstadoPedido estadoPedido;

	public Integer getCodigo_pedido() {
		return codigo_pedido;
	}

	public void setCodigo_pedido(Integer codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

	public Date getFecha_solicitud_pedido() {
		return fecha_solicitud_pedido;
	}

	public void setFecha_solicitud_pedido(Date fecha_solicitud_pedido) {
		this.fecha_solicitud_pedido = fecha_solicitud_pedido;
	}

	public String getFecha_entrega_pedido() {
		return fecha_entrega_pedido;
	}

	public void setFecha_entrega_pedido(String fecha_entrega_pedido) {
		this.fecha_entrega_pedido = fecha_entrega_pedido;
	}

	public Double getMonto_pedido() {
		return monto_pedido;
	}

	public void setMonto_pedido(Double monto_pedido) {
		this.monto_pedido = monto_pedido;
	}

	public Integer getCodigo_repartidor() {
		return codigo_repartidor;
	}

	public void setCodigo_repartidor(Integer codigo_repartidor) {
		this.codigo_repartidor = codigo_repartidor;
	}

	public Integer getCodigo_estado_pedido() {
		return codigo_estado_pedido;
	}

	public void setCodigo_estado_pedido(Integer codigo_estado_pedido) {
		this.codigo_estado_pedido = codigo_estado_pedido;
	}

	public Usuario getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(Usuario usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public Usuario getUsuarioRepartidor() {
		return usuarioRepartidor;
	}

	public void setUsuarioRepartidor(Usuario usuarioRepartidor) {
		this.usuarioRepartidor = usuarioRepartidor;
	}

	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

}
