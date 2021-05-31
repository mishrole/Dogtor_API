package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import com.dogtorAPI.entity.Pedido;

public interface PedidoService {
	public abstract List<Pedido> listaPedido();
	public abstract List<Pedido> listaPedidoPorCliente(Integer codigo_cliente);
	public abstract List<Pedido> listaPedidoPorRepartidor(Integer codigo_repartidor);
	public abstract Optional<Pedido> obtienePorId(Integer codigo_pedido);
	public abstract Pedido insertaPedido(Pedido objPedido);
}
