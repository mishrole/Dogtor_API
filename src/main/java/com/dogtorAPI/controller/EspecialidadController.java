package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Especialidad;
import com.dogtorAPI.service.EspecialidadService;

@RestController
@RequestMapping("/rest/especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService service;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> lista() {
		List<Especialidad> listaEspecialidad = service.listaEspecialidad();
		return ResponseEntity.ok(listaEspecialidad);
	}
	
}
