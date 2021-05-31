package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Marca;
import com.dogtorAPI.service.MarcaService;

@RestController
@RequestMapping("/rest/marca")
public class MarcaController {
	
	@Autowired
	private MarcaService service;
	
	@GetMapping
	public ResponseEntity<List<Marca>> lista() {
		List<Marca> listaMarca = service.listaMarca();
		return ResponseEntity.ok(listaMarca);
	}

}
