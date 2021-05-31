package com.dogtorAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dogtorAPI.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Query("Select p from Pedido p, Usuario u, EstadoPedido ep where p.usuarioCliente.codigo_usuario = u.codigo_usuario and p.estadoPedido.codigo_estado_pedido = ep.codigo_estado_pedido and p.codigo_cliente like :param_cliente")
	public abstract List<Pedido> listaPedidoPorCliente(@Param("param_cliente") Integer codigo_cliente);
	
	@Query("Select p from Pedido p, Usuario u, EstadoPedido ep where p.usuarioRepartidor.codigo_usuario = u.codigo_usuario and p.estadoPedido.codigo_estado_pedido = ep.codigo_estado_pedido and p.codigo_repartidor like :param_repartidor")
	public abstract List<Pedido> listaPedidoPorRepartidor(@Param("param_repartidor") Integer codigo_repartidor);
}
