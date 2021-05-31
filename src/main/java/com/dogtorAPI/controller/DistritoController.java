package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.Distrito;
import com.dogtorAPI.service.DistritoService;

@Controller
public class DistritoController {
	
	@Autowired
	private DistritoService service;
	
	@RequestMapping("/listaDistrito")
	@ResponseBody
	public List<Distrito> listaDistrito() {
		return service.listaDistrito();
	}
}
