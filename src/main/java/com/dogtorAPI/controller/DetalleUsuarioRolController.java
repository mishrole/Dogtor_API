package com.dogtorAPI.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.DetalleUsuarioRol;
import com.dogtorAPI.entity.DetalleUsuarioRolPK;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.service.DetalleUsuarioRolService;
import com.dogtorAPI.service.RolService;

@RestController
@RequestMapping("/rest/DetalleUsuarioRol")
public class DetalleUsuarioRolController {
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private DetalleUsuarioRolService detalleUsuarioRolService;
	
	@PostMapping(path = "/registraDetalleUsuarioRol/{codigo_usuario}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> registraDetalleUsuarioRol(@PathVariable("codigo_usuario") Integer codigo_usuario, @RequestBody Map<String, Object> json) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		DetalleUsuarioRolPK objRolUsuarioPK = new DetalleUsuarioRolPK();
		objRolUsuarioPK.setCodigo_rol_usuario((Integer) json.get("codigo_rol_usuario"));
		objRolUsuarioPK.setCodigo_usuario(codigo_usuario);
		
		DetalleUsuarioRol objRolUsuario = new DetalleUsuarioRol();
		objRolUsuario.setObjDetalleUsuarioRolPK(objRolUsuarioPK);
		
		DetalleUsuarioRol objDetalleSalida = detalleUsuarioRolService.insertaUsuarioRol(objRolUsuario);
		
		if(objDetalleSalida != null) {
			salida.put("lista", rolService.listaRolPorUsuario(objRolUsuarioPK.getCodigo_usuario()));
		} else {
			salida.put("MENSAJE", "El registro no pudo ser completado");
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@RequestMapping("/eliminaDetalleUsuarioRol")
	@ResponseBody
	public List<Rol> eliminaDetalleUsuarioRol(DetalleUsuarioRol detalleUsuarioRol) {		
		detalleUsuarioRolService.eliminaUsuarioRol(detalleUsuarioRol);
		return rolService.listaRolPorUsuario(detalleUsuarioRol.getObjDetalleUsuarioRolPK().getCodigo_usuario());
	}
	

}
