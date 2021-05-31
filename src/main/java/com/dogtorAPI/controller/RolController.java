package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.service.RolService;

@RestController
@RequestMapping("/rest/rol")
public class RolController {
	
	@Autowired
	private RolService service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> lista() {
		List<Rol> listaRol = service.listaRol();
		return ResponseEntity.ok(listaRol);
	}
	
	@GetMapping(path = "/listaRolPorUsuario/{codigo_usuario}")
	public ResponseEntity<List<Rol>> listaRolPorUsuario(@PathVariable("codigo_usuario") Integer codigo_usuario) {
		List<Rol> listaRolPorUsuario = service.listaRolPorUsuario(codigo_usuario);
		return ResponseEntity.ok(listaRolPorUsuario);
	}
	
}
