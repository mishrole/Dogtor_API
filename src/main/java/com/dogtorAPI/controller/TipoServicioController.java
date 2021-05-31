package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.TipoServicio;
import com.dogtorAPI.service.TipoServicioService;

@RestController
@RequestMapping("/rest/tiposervicio")
public class TipoServicioController {
	
	@Autowired
	private TipoServicioService service;
	
	@GetMapping
	public ResponseEntity<List<TipoServicio>> lista() {
		List<TipoServicio> listaTipoServicio = service.listaTipoServicio();
		return ResponseEntity.ok(listaTipoServicio);
	}

}
