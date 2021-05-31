package com.dogtorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dogtorAPI.entity.DetalleUsuarioRol;
import com.dogtorAPI.entity.DetalleUsuarioRolPK;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.service.DetalleUsuarioRolService;
import com.dogtorAPI.service.RolService;

@Controller
public class DetalleUsuarioRolController {
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private DetalleUsuarioRolService detalleUsuarioRolService;
	
	@RequestMapping("/registraDetalleUsuarioRol")
	@ResponseBody
	public List<Rol> registraDetalleUsuarioRol(Integer codigo_rol_usuario, Integer codigo_usuario) {
		DetalleUsuarioRolPK objRolUsuarioPK = new DetalleUsuarioRolPK();
		objRolUsuarioPK.setCodigo_rol_usuario(codigo_rol_usuario);
		objRolUsuarioPK.setCodigo_usuario(codigo_usuario);
		
		DetalleUsuarioRol objRolUsuario = new DetalleUsuarioRol();
		objRolUsuario.setObjDetalleUsuarioRolPK(objRolUsuarioPK);
		
		detalleUsuarioRolService.insertaUsuarioRol(objRolUsuario);
		return rolService.listaRolPorUsuario(codigo_usuario);
	}
	
	@RequestMapping("/eliminaDetalleUsuarioRol")
	@ResponseBody
	public List<Rol> eliminaDetalleUsuarioRol(DetalleUsuarioRol detalleUsuarioRol) {		
		detalleUsuarioRolService.eliminaUsuarioRol(detalleUsuarioRol);
		return rolService.listaRolPorUsuario(detalleUsuarioRol.getObjDetalleUsuarioRolPK().getCodigo_usuario());
	}
	

}
