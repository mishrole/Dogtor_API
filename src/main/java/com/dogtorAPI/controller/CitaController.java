package com.dogtorAPI.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.Cita;
import com.dogtorAPI.service.CitaService;

@Controller
public class CitaController {
	
	@Autowired
	private CitaService service;
	
	@RequestMapping("/listaCitaPorCodigo")
	@ResponseBody
	public List<Cita> listaCitaPorCodigo(Integer codigo_cita) {
		return service.listaCitaPorCodigo(codigo_cita);
	}
	
	@RequestMapping("/listaCita")
	@ResponseBody
	public List<Cita> listaCita() {
		return service.listaCita();
	}
	
	@RequestMapping("/listaCitaPorUsuario")
	@ResponseBody
	public List<Cita> listaCitaPorUsuario(Integer codigo_usuario) {
		return service.listaCitaPorUsuario(codigo_usuario);
	}
	
	@RequestMapping("/registraCita")
	@ResponseBody
	public Map<String, Object> registra(Cita objCita) {
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
		
		return salida;
	}
	
	@RequestMapping("/actualizaEstadoCita")
	@ResponseBody
	public Map<String, Object> actualizaEstadoCita(Integer codigo_cita, Integer codigo_estado_cita) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Cita> option = service.obtienePorId(codigo_cita);
		
		try {
			if(option.isPresent()) {
				option.ifPresent((Cita result) -> {
					result.setCodigo_estado_cita(codigo_estado_cita);
					
					Cita citaSalida = service.insertaCita(result);
					
					if(citaSalida != null) {
						salida.put("MENSAJE", "El estado de la cita ha sido modificado");
					}
				});
			} else {
				salida.put("MENSAJE", "Error, la cita no existe");
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, la cita no pudo ser actualizada");
		} finally {
			List<Cita> lista = service.listaCita();
			salida.put("lista", lista);
		}
		
		return salida;
	}
}
