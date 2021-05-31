package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.TipoServicio;
import com.dogtorAPI.service.TipoServicioService;

@Controller
public class TipoServicioController {
	
	@Autowired
	private TipoServicioService service;
	
	@RequestMapping("/listaTipoServicio")
	@ResponseBody
	public List<TipoServicio> listaTipoServicio() {
		return service.listaTipoServicio();
	}
}
