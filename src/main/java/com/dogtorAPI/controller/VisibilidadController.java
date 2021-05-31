package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.Visibilidad;
import com.dogtorAPI.service.VisibilidadService;

@Controller
public class VisibilidadController {
	
	@Autowired
	private VisibilidadService service;
	
	@RequestMapping("/listaVisibilidad")
	@ResponseBody
	public List<Visibilidad> listaVisibilidad() {
		return service.listaVisibilidad();
	}
}
