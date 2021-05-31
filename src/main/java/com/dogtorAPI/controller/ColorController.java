package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Color;
import com.dogtorAPI.service.ColorService;

@RestController
@RequestMapping("/rest/color")
public class ColorController {
	
	@Autowired
	private ColorService service;
	
	@GetMapping
	public ResponseEntity<List<Color>> lista() {
		List<Color> listaColor = service.listaColor();
		return ResponseEntity.ok(listaColor);
	}

}
