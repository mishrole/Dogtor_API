package com.dogtorAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Pedido;
import com.dogtorAPI.service.PedidoService;

@RestController
@RequestMapping("/rest/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> lista() {
		List<Pedido> listaPedido = service.listaPedido();
		return ResponseEntity.ok(listaPedido);
	}
	
	@GetMapping(path = "/listaPedidoPorCliente/{codigo_cliente}")
	public ResponseEntity<List<Pedido>> listaPedidoPorCliente(@PathVariable("codigo_cliente") Integer codigo_cliente) {
		List<Pedido> listaPedido = service.listaPedidoPorCliente(codigo_cliente);
		return ResponseEntity.ok(listaPedido);
	}
	
	@GetMapping(path = "/listaPedidoPorCliente/{codigo_repartidor}")
	public ResponseEntity<List<Pedido>> listaPedidoPorRepartidor(@PathVariable("codigo_repartidor") Integer codigo_repartidor) {
		List<Pedido> listaPedido = service.listaPedidoPorRepartidor(codigo_repartidor);
		return ResponseEntity.ok(listaPedido);
	}
	
	@PutMapping(path = "/actualizaEstadoPedido/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> actualizaEstadoPedido(@PathVariable("id") Integer id, @RequestBody Map<String, Object> json) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		//Optional<Pedido> option = service.obtienePorId((Integer) json.get("codigo_pedido"));
		Optional<Pedido> option = service.obtienePorId(id);
		
		if(option.isPresent()) {
			try {
				option.ifPresent((Pedido result) -> {
					result.setCodigo_estado_pedido((Integer) json.get("codigo_estado_pedido"));
					
					Pedido pedidoSalida = service.insertaPedido(result);
					
					if(pedidoSalida != null) {
						salida.put("MENSAJE", "El pedido ha sido modificado");
					} else {
						salida.put("MENSAJE", "El pedido no pudo ser actualizado");
					}
					
				});
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("MENSAJE", "Error, el pedido no pudo ser actualizado");
			} finally {
				List<Pedido> lista = service.listaPedido();
				salida.put("lista", lista);
			}
		}
		
		return ResponseEntity.ok(salida);
	}
	
}
