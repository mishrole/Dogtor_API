package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Raza;
import com.dogtorAPI.service.RazaService;

@RestController
@RequestMapping("/rest/raza")
public class RazaController {
	
	@Autowired RazaService service;
	
	@GetMapping(path = "/listaRaza/{codigo_especie}")
	public ResponseEntity<List<Raza>> lista(@PathVariable("codigo_especie") Integer codigo_especie) {
		List<Raza> listaRaza = service.listaRaza(codigo_especie);
		return ResponseEntity.ok(listaRaza);
	}

}
