package com.dogtorAPI.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.Cita;
import com.dogtorAPI.service.CitaService;

@RestController
@RequestMapping("/rest/cita")
public class CitaController {
	
	@Autowired
	private CitaService service;
	
	@GetMapping
	public ResponseEntity<List<Cita>> lista() {
		List<Cita> listaCita = service.listaCita();
		return ResponseEntity.ok(listaCita);
	}
	
	@GetMapping(path = "/listaCitaPorCodigo/{codigo_cita}")
	public ResponseEntity<List<Cita>> listaCitaPorCodigo(@PathVariable("codigo_cita") Integer codigo_cita) {
		List<Cita> listaCita = service.listaCitaPorCodigo(codigo_cita);
		return ResponseEntity.ok(listaCita);
	}
	
	@GetMapping(path = "/listaCitaPorUsuario/{codigo_usuario}")
	public ResponseEntity<List<Cita>> listaCitaPorUsuario(@PathVariable("codigo_usuario") Integer codigo_usuario) {
		List<Cita> listaCita = service.listaCitaPorUsuario(codigo_usuario);
		return ResponseEntity.ok(listaCita);
	}
	
	@PostMapping(path = "/registraCita", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> registraCita(@RequestBody Cita objCita) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		objCita.setFecha_solicitud_cita(new Date());
		objCita.setCodigo_estado_cita(1);
		
		Cita objSalida = null;
		
		try {
			objSalida = service.insertaCita(objCita);
			if(objSalida == null) {
				salida.put("MENSAJE", "El registro no pudo ser completado");
			} else {
				salida.put("MENSAJE", "¡Registro exitoso!");
			}
		} catch (Exception e) {
			salida.put("MENSAJE", "El registro no pudo ser completado");
		} finally {
			List<Cita> lista = service.listaCita();
			salida.put("lista", lista);
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping(path = "/actualizaEstadoCita/{codigo_cita}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> actualizaEstadoCita(@PathVariable("codigo_cita") Integer codigo_cita, @RequestBody Map<String, Object> json) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Cita> option = service.obtienePorId(codigo_cita);
		
		if(option.isPresent()) {
			try {
				option.ifPresent((Cita result) -> {
					result.setCodigo_estado_cita((Integer) json.get("codigo_estado_cita"));
					
					Cita citaSalida = service.insertaCita(result);
					
					if(citaSalida != null) {
						salida.put("MENSAJE", "La cita ha sido modificado");
					} else {
						salida.put("MENSAJE", "La cita no pudo ser actualizada");
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("MENSAJE", "Error, la cita no pudo ser actualizada");
			} finally {
				List<Cita> lista = service.listaCita();
				salida.put("lista", lista);
			}
		} else {
			salida.put("MENSAJE", "Error, la cita no existe");
		}
		
		return ResponseEntity.ok(salida);
		
	}

}
