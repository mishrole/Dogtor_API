package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.DiaSemana;
import com.dogtorAPI.service.DiaSemanaService;

@RestController
@RequestMapping("/rest/diasemana")
public class DiaSemanaController {

	@Autowired
	private DiaSemanaService service;

	@GetMapping
	public ResponseEntity<List<DiaSemana>> lista() {
		List<DiaSemana> listaDiaSemana = service.listaDiaSemana();
		return ResponseEntity.ok(listaDiaSemana);
	}

}
