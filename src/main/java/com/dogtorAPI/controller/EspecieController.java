package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Especie;
import com.dogtorAPI.service.EspecieService;

@RestController
@RequestMapping("/rest/especie")
public class EspecieController {

	@Autowired
	private EspecieService service;
	
	@GetMapping
	public ResponseEntity<List<Especie>> lista() {
		List<Especie> listaEspecie = service.listaEspecie();
		return ResponseEntity.ok(listaEspecie);
	}

}
