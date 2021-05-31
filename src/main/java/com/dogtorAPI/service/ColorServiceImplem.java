package com.dogtorAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogtorAPI.entity.Color;
import com.dogtorAPI.repository.ColorRepository;

@Service
public class ColorServiceImplem implements ColorService {

	@Autowired
	private ColorRepository repository;

	@Override
	public List<Color> listaColor() {
		return repository.listaColor();
	}
}
