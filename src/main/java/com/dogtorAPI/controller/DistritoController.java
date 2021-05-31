package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Distrito;
import com.dogtorAPI.service.DistritoService;

@RestController
@RequestMapping("/rest/distrito")
public class DistritoController {
	
	@Autowired
	private DistritoService service;
	
	@GetMapping
	public ResponseEntity<List<Distrito>> lista() {
		List<Distrito> listaDistrito = service.listaDistrito();
		return ResponseEntity.ok(listaDistrito);
	}
	
}
