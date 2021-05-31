package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Sexo;
import com.dogtorAPI.service.SexoService;

@RestController
@RequestMapping("/rest/sexo")
public class SexoController {
	
	@Autowired
	private SexoService service;
	
	@GetMapping
	public ResponseEntity<List<Sexo>> lista() {
		List<Sexo> listaSexo = service.listaSexo();
		return ResponseEntity.ok(listaSexo);
	}
}
