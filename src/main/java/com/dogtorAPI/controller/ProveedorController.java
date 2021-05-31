package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Proveedor;
import com.dogtorAPI.service.ProveedorService;

@RestController
@RequestMapping("/rest/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService service;
	
	@GetMapping
	public ResponseEntity<List<Proveedor>> lista() {
		List<Proveedor> listaProveedor = service.listaProveedor();
		return ResponseEntity.ok(listaProveedor);
	}
}
