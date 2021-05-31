package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.CategoriaProducto;
import com.dogtorAPI.service.CategoriaProductoService;

@RestController
@RequestMapping("/rest/categoria")
public class CategoriaProductoController {
	
	@Autowired
	private CategoriaProductoService service;
	
	@GetMapping
	public ResponseEntity<List<CategoriaProducto>> lista() {
		List<CategoriaProducto> listaCategoriaProducto = service.listaCategoriaProducto();
		return ResponseEntity.ok(listaCategoriaProducto);
	}

}
