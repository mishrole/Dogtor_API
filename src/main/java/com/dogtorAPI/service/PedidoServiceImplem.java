package com.dogtorAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Pedido;
import com.dogtorAPI.repository.PedidoRepository;

@Service
public class PedidoServiceImplem implements PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Override
	public List<Pedido> listaPedido() {
		return repository.findAll();
	}

	@Override
	public List<Pedido> listaPedidoPorCliente(Integer codigo_cliente) {
		return repository.listaPedidoPorCliente(codigo_cliente);
	}

	@Override
	public Optional<Pedido> obtienePorId(Integer codigo_pedido) {
		return repository.findById(codigo_pedido);
	}

	@Override
	public Pedido insertaPedido(Pedido objPedido) {
		return repository.save(objPedido);
	}

	@Override
	public List<Pedido> listaPedidoPorRepartidor(Integer codigo_repartidor) {
		return repository.listaPedidoPorRepartidor(codigo_repartidor);
	}
	
	
}
