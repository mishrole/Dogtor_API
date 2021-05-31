package com.dogtorAPI.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dogtorAPI.entity.Enlace;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.entity.Usuario;
import com.dogtorAPI.service.UsuarioService;

@Controller
public class AccesoController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping("/test")
	public String verTest() {
		return "test";
	}
	
	@RequestMapping("/")
	public String verInicio() {
		return "inicio";
	}
	
	@RequestMapping("/login")
	public String verLogin() {
		return "iniciaSesion";
	}
	
	@RequestMapping("/acceder")
	public String login(Usuario objUsuario, HttpSession session, HttpServletRequest request) {
		Usuario usuario = service.login(objUsuario);
		
		if(usuario == null) {
			request.setAttribute("MENSAJE", "El usuario y/o contraseña son incorrectos");
			return "iniciaSesion";
		} else {
			
			if(usuario.getCodigo_visibilidad() != 1) {
				request.setAttribute("MENSAJE", "El usuario se encuentra deshabilitado");
				return "iniciaSesion";
			}
			
			List<Enlace> menus = service.obtenerEnlacesDeUsuario(usuario.getCodigo_usuario());
			List<Rol> roles = service.obtenerRolesDeUsuario(usuario.getCodigo_usuario());
			
			if(roles.size() < 1 || menus.size() < 1) {
				request.setAttribute("MENSAJE", "El usuario no ha sido habilitado");
				return "iniciaSesion";
			}
			
			session.setAttribute("objUsuario", usuario);
			session.setAttribute("objMenus", menus);
			session.setAttribute("objRoles", roles);
			session.setAttribute("currentRol", roles.get(0).getNombre_rol_usuario());

			return "redirect:home";
			
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		
		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");
		
		request.setAttribute("MENSAJE", "El usuario cerró sesión");
		return "iniciaSesion";
	}
	
	/* Cliente */
	
	@RequestMapping("/verMisMascotas")
	public String verMisMascotas() {
		return "clienteMascota";
	}
	
	@RequestMapping("/verMisCitas")
	public String verMisCitas() {
		return "clienteCita";
	}
	
	@RequestMapping("/verMisPedidos")
	public String verMisPedidos() {
		return "clientePedido";
	}
	
	@RequestMapping("/verTienda")
	public String verTienda() {
		return "clienteTienda";
	}
	
	/* Vendedor */

	@RequestMapping("/verReserva")
	public String verReserva() {
		return "crudReserva";
	}
	
	@RequestMapping("/verVenta")
	public String verVenta() {
		return "crudVenta";
	}
	
	@RequestMapping("/notFound")
	public String verError() {
		return "error";
	}
	
	@RequestMapping("/home")
	public String verHome(HttpSession session) {
		
		if(session.getAttribute("currentRol") == null) {
			return "redirect:notFound";
		} else {
			switch((String)session.getAttribute("currentRol")) {
			case "Administrador":
				return "homeAdministrador";
			case "Cliente":
				return "homeCliente";
			case "Especialista":
				return "homeEspecialista";
			case "Vendedor":
				return "homeVendedor";
			case "Repartidor":
				return "homeRepartidor";
			default:
				return "redirect:notFound";
			}
		}
	}
	
}
