package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.DiaSemana;
import com.dogtorAPI.service.DiaSemanaService;

@Controller
public class DiaSemanaController {

	@Autowired
	private DiaSemanaService service;

	@RequestMapping("/listaDiaSemana")
	@ResponseBody
	public List<DiaSemana> listaDiaSemana() {
		return service.listaDiaSemana();
	}
}
