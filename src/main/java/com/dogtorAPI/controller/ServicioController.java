package com.dogtorAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Servicio;
import com.dogtorAPI.service.ServicioService;

@RestController
@RequestMapping("/rest/servicio")
public class ServicioController {
	
	@Autowired
	private ServicioService service;
	
	@GetMapping
	public ResponseEntity<List<Servicio>> lista() {
		List<Servicio> listaServicio = service.listaServicio();
		return ResponseEntity.ok(listaServicio);
	}
	
	@GetMapping(path = "/listaServicioPorNombre/{nombre_usuario}")
	public ResponseEntity<List<Servicio>> listaServicioPorNombre(@PathVariable("nombre_usuario") String nombre_usuario) {
		List<Servicio> listaServicio = service.listaServicioPorNombreLike(nombre_usuario);
		return ResponseEntity.ok(listaServicio);
	}
	
	@GetMapping(path = "listaServicioPorTipoYEspecialidad")
	public ResponseEntity<List<Servicio>> listaServicioPorTipoYEspecialidad(Integer codigo_tipo, Integer codigo_especialidad) {
		List<Servicio> listaServicio = service.listaServicioPorTipoYEspecialidad(codigo_tipo, codigo_especialidad);
		return ResponseEntity.ok(listaServicio);
	}
	
	@PostMapping(path = "/registraServicio", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> registraServicio (Servicio objServicio) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Servicio objSalida = null;
		
		try {
			objSalida = service.insertaServicio(objServicio);
			if (objSalida == null) {
				salida.put("MENSAJE", "El registro no pudo ser completado");
			} else {
				salida.put("MENSAJE", "¡Registro exitoso!");
			}
		} catch (Exception e) {
			salida.put("MENSAJE", "El registro no pudo ser completado");
		} finally {
			List<Servicio> lista = service.listaServicio();
			salida.put("lista", lista);
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping(path = "/actualizaServicio", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> actualizaServicio(@RequestBody Servicio objServicio) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			
			Optional<Servicio> option = service.obtienePorId(objServicio.getCodigo_servicio());
			
			if (option.isPresent()) {
				Servicio objSalida = service.insertaServicio(objServicio);
				if (objSalida == null) {
					salida.put("MENSAJE", "La actualización no pudo ser completada");
				} else {
					salida.put("MENSAJE", "¡Actualización exitosa!");
				}
			} else {
				salida.put("MENSAJE", "Error, el servicio no existe");
			}
			
		} catch (Exception e) {
			salida.put("MENSAJE", "La actualización no pudo ser completada");
		} finally {
			List<Servicio> lista = service.listaServicio();
			salida.put("lista", lista);
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@DeleteMapping(path = "/eliminaServicio/{id}")
	public ResponseEntity<Map<String, Object>> eliminaServicio(@PathVariable("codigo_servicio") Integer codigo_servicio) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			Optional<Servicio> option = service.obtienePorId(codigo_servicio);
			
			if (option.isPresent()) {
				service.eliminaServicio(codigo_servicio);
				salida.put("MENSAJE", "¡Eliminación exitosa!");
			} else {
				salida.put("MENSAJE", "Error, el servicio no existe");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, el servicio no pudo ser eliminado");
		} finally {
			List<Servicio> lista = service.listaServicio();
			salida.put("lista", lista);
		}
		
		return ResponseEntity.ok(salida);
	}
	
}
