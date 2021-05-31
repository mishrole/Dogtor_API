package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.Color;
import com.dogtorAPI.service.ColorService;

@Controller
public class ColorController {
	
	@Autowired
	private ColorService service;
	
	@RequestMapping("/listaColor")
	@ResponseBody
	public List<Color> listaColor() {
		return service.listaColor();
	}

}
