package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.Especie;
import com.dogtorAPI.service.EspecieService;

@Controller
public class EspecieController {

	@Autowired
	private EspecieService service;
	
	@RequestMapping("/listaEspecie")
	@ResponseBody
	public List<Especie> listaEspecie() {
		return service.listaEspecie();
	}

}
