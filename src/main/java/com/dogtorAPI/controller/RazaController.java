package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.Raza;
import com.dogtorAPI.service.RazaService;

@Controller
public class RazaController {
	
	@Autowired RazaService service;
	
	@RequestMapping("listaRaza")
	@ResponseBody
	public List<Raza> listaRaza(Integer especie) {
		return service.listaRaza(especie);
	}
}
