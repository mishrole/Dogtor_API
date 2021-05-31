package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Visibilidad;
import com.dogtorAPI.service.VisibilidadService;

@RestController
@RequestMapping("/rest/visibilidad")
public class VisibilidadController {
	
	@Autowired
	private VisibilidadService service;
	
	@GetMapping
	public ResponseEntity<List<Visibilidad>> lista() {
		List<Visibilidad> listaVisibilidad = service.listaVisibilidad();
		return ResponseEntity.ok(listaVisibilidad);
	}
	
}
