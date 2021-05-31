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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dogtorAPI.entity.DetalleUsuarioRol;
import com.dogtorAPI.entity.DetalleUsuarioRolPK;
import com.dogtorAPI.entity.Rol;
import com.dogtorAPI.entity.Usuario;
import com.dogtorAPI.service.DetalleUsuarioRolService;
import com.dogtorAPI.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DetalleUsuarioRolService detalleUsuarioRolService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> lista() {
		List<Usuario> listaUsuario = usuarioService.listaUsuario();
		return ResponseEntity.ok(listaUsuario);
	}
	
	@GetMapping(path = "/listaUsuarioPorNombre/{nombre_usuario}")
	public ResponseEntity<List<Usuario>> listaUsuarioPorNombre(@PathVariable("nombre_usuario") String nombre_usuario) {
		List<Usuario> listaUsuario = usuarioService.listaUsuarioPorNombre(nombre_usuario);
		return ResponseEntity.ok(listaUsuario);
	}
	
	@GetMapping(path = "/listaUsuarioPorRol/{codigo_rol_usuario}")
	public ResponseEntity<List<Usuario>> listaUsuarioPorRol(@PathVariable("codigo_rol_usuario") Integer codigo_rol_usuario) {
		List<Usuario> listaUsuario = usuarioService.listaUsuarioPorRol(codigo_rol_usuario);
		return ResponseEntity.ok(listaUsuario);
	}
	
	@GetMapping(path = "/listaUsuarioPorNombreYRol")
	public ResponseEntity<List<Usuario>> listaUsuarioPorNombreYRol(String nombre_usuario, Integer codigo_rol_usuario) {
		List<Usuario> listaUsuario = usuarioService.listaUsuarioPorNombreYRol(nombre_usuario, codigo_rol_usuario);
		return ResponseEntity.ok(listaUsuario);
	}
	
	@PostMapping(path = "/registraCliente", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> registraCliente(@RequestBody Usuario objUsuario) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		List<Usuario> verificarEmail = usuarioService.obtenerUsuarioPorEmail(objUsuario.getEmail_usuario());

		if(verificarEmail.size() < 1) {
			try {
				objUsuario.setCodigo_visibilidad(1); // 1 Visible
				Usuario objSalida = usuarioService.insertaUsuario(objUsuario);
				
				if(objSalida != null) {
					DetalleUsuarioRolPK objRolUsuarioPK = new DetalleUsuarioRolPK();
					objRolUsuarioPK.setCodigo_rol_usuario(2); // 2 Cliente
					objRolUsuarioPK.setCodigo_usuario(objSalida.getCodigo_usuario());
					
					DetalleUsuarioRol objRolUsuario = new DetalleUsuarioRol();
					objRolUsuario.setObjDetalleUsuarioRolPK(objRolUsuarioPK);
					
					DetalleUsuarioRol objDetalleSalida = detalleUsuarioRolService.insertaUsuarioRol(objRolUsuario);
					
					if(objDetalleSalida == null) {
						usuarioService.eliminaUsuario(objSalida.getCodigo_usuario());
						salida.put("MENSAJE", "La cuenta no pudo ser creada");
					} else {
						salida.put("MENSAJE", "¡Registro exitoso!");
					}
					
				} else {
					salida.put("MENSAJE", "El registro de cliente no pudo ser completado");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			salida.put("MENSAJE", "El email ya se encuentra en uso");
			salida.put("VALIDACION", "no-reset");
		}
	
		return ResponseEntity.ok(salida);
		
	}
	
	@PostMapping(path = "/registraUsuario", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> registraUsuario(@RequestBody Map<String, Object> json) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Usuario objUsuario = new Usuario();
		objUsuario.setEmail_usuario((String) json.get("email_usuario"));
		objUsuario.setContrasena_usuario((String) json.get("contrasena_usuario"));
		objUsuario.setNombre_usuario((String) json.get("nombre_usuario"));
		objUsuario.setApellido_usuario((String) json.get("apellido_usuario"));
		objUsuario.setFecha_nacimiento_usuario((String) json.get("fecha_nacimiento_usuario"));
		objUsuario.setGenero_usuario((String) json.get("genero_usuario"));
		objUsuario.setDni_usuario((String) json.get("dni_usuario"));
		objUsuario.setDireccion_usuario((String) json.get("direccion_usuario"));
		objUsuario.setReferencia_usuario((String) json.get("referencia_usuario"));
		objUsuario.setTelefono_usuario((String) json.get("telefono_usuario"));
		objUsuario.setCodigo_distrito((Integer) json.get("codigo_distrito"));
		objUsuario.setCodigo_visibilidad((Integer) json.get("codigo_visibilidad"));
		
		List<Usuario> verificarEmail = usuarioService.obtenerUsuarioPorEmail(objUsuario.getEmail_usuario());
		
		if(verificarEmail.size() < 1) {
			try {
				Usuario objSalida = usuarioService.insertaUsuario(objUsuario);
				
				if(objSalida != null) {
					DetalleUsuarioRolPK objRolUsuarioPK = new DetalleUsuarioRolPK();
					objRolUsuarioPK.setCodigo_rol_usuario((Integer) json.get("codigo_rol_usuario"));
					objRolUsuarioPK.setCodigo_usuario(objSalida.getCodigo_usuario());
					
					DetalleUsuarioRol objRolUsuario = new DetalleUsuarioRol();
					objRolUsuario.setObjDetalleUsuarioRolPK(objRolUsuarioPK);
					
					DetalleUsuarioRol objDetalleSalida = detalleUsuarioRolService.insertaUsuarioRol(objRolUsuario);
					
					if(objDetalleSalida == null) {
						usuarioService.eliminaUsuario(objSalida.getCodigo_usuario());
						salida.put("MENSAJE", "La cuenta no pudo ser creada");	
					} else {
						salida.put("MENSAJE", "¡Registro exitoso!");
					}
					
				} else {
					salida.put("MENSAJE", "El registro no pudo ser completado");
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				List<Usuario> lista = usuarioService.listaUsuarioPorNombre("");
				salida.put("lista", lista);
			}
		} else {
			salida.put("MENSAJE", "El email ya se encuentra en uso");
			salida.put("VALIDACION", "no-reset");
		}

		return ResponseEntity.ok(salida);
	}
	
	@PutMapping(path = "/actualizaUsuario", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> actualizaUsuario(@RequestBody Map<String, Object> json) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Usuario objUsuario = new Usuario();
		objUsuario.setCodigo_usuario((Integer) json.get("codigo_usuario"));
		objUsuario.setEmail_usuario((String) json.get("email_usuario"));
		objUsuario.setContrasena_usuario((String) json.get("contrasena_usuario"));
		objUsuario.setNombre_usuario((String) json.get("nombre_usuario"));
		objUsuario.setApellido_usuario((String) json.get("apellido_usuario"));
		objUsuario.setFecha_nacimiento_usuario((String) json.get("fecha_nacimiento_usuario"));
		objUsuario.setGenero_usuario((String) json.get("genero_usuario"));
		objUsuario.setDni_usuario((String) json.get("dni_usuario"));
		objUsuario.setDireccion_usuario((String) json.get("direccion_usuario"));
		objUsuario.setReferencia_usuario((String) json.get("referencia_usuario"));
		objUsuario.setTelefono_usuario((String) json.get("telefono_usuario"));
		objUsuario.setCodigo_distrito((Integer) json.get("codigo_distrito"));
		objUsuario.setCodigo_visibilidad((Integer) json.get("codigo_visibilidad"));
		
		Optional<Usuario> option = usuarioService.obtieneUsuarioPorId(objUsuario.getCodigo_usuario());
		
		if(option.isPresent()) {
			
			try {
				Usuario objSalida = usuarioService.insertaUsuario(objUsuario);
				
				if(objSalida != null) {
					DetalleUsuarioRolPK objRolUsuarioPK = new DetalleUsuarioRolPK();
					objRolUsuarioPK.setCodigo_rol_usuario((Integer) json.get("codigo_rol_usuario"));
					objRolUsuarioPK.setCodigo_usuario(objSalida.getCodigo_usuario());
					
					DetalleUsuarioRol objRolUsuario = new DetalleUsuarioRol();
					objRolUsuario.setObjDetalleUsuarioRolPK(objRolUsuarioPK);
					
					DetalleUsuarioRol objDetalleSalida = detalleUsuarioRolService.insertaUsuarioRol(objRolUsuario);
					
					if(objDetalleSalida == null) {
						salida.put("MENSAJE", "La cuenta no pudo ser actualizada");	
					} else {
						salida.put("MENSAJE", "¡Actualización exitosa!");
					}
				} else {
					salida.put("MENSAJE", "La actualización no pudo ser completada");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				List<Usuario> lista = usuarioService.listaUsuarioPorNombre("");
				salida.put("lista", lista);
			}
			
		} else {
			salida.put("MENSAJE", "Error, el usuario no existe");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping(path = "/actualizaVisibilidadUsuario", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Map<String, Object>> actualizaVisibilidadUsuario(@RequestBody Map<String, Object> json) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Usuario objUsuario = new Usuario();
		objUsuario.setCodigo_usuario((Integer) json.get("codigo_usuario"));
		objUsuario.setCodigo_visibilidad((Integer) json.get("codigo_visibilidad"));
		
		Optional<Usuario> option = usuarioService.obtieneUsuarioPorId(objUsuario.getCodigo_usuario());
		
		if(option.isPresent()) {
			try {
				option.ifPresent((Usuario result) -> {
					result.setCodigo_visibilidad(objUsuario.getCodigo_visibilidad());
					
					Usuario objSalida = usuarioService.insertaUsuario(result);
					
					if(objSalida != null) {
						salida.put("MENSAJE", "La cuenta ha sido modificada");
					} else {
						salida.put("MENSAJE", "La cuenta no pudo ser actualizada");
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("MENSAJE", "Error, la cuenta no pudo ser actualizada");
			} finally {
				List<Usuario> lista = usuarioService.listaUsuarioPorNombre("");
				salida.put("lista", lista);
			}
			
		} else {
			salida.put("MENSAJE", "Error, el usuario no existe");
		}
		
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping(path = "/eliminaUsuario/{id}")
	public ResponseEntity<Map<String, Object>> eliminaUsuario (@PathVariable("id") Integer codigo_usuario) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Usuario> option = usuarioService.obtieneUsuarioPorId(codigo_usuario);
		
		if(option.isPresent()) {
			try {
				List<Rol> roles = usuarioService.obtenerRolesDeUsuario(codigo_usuario);
				DetalleUsuarioRolPK objRolUsuarioPK = new DetalleUsuarioRolPK();
				objRolUsuarioPK.setCodigo_rol_usuario(roles.get(0).getCodigo_rol_usuario());
				objRolUsuarioPK.setCodigo_usuario(codigo_usuario);
				
				DetalleUsuarioRol objRolUsuario = new DetalleUsuarioRol();
				objRolUsuario.setObjDetalleUsuarioRolPK(objRolUsuarioPK);
									
				detalleUsuarioRolService.eliminaUsuarioRol(objRolUsuario);
				
				try {
					usuarioService.eliminaUsuario(codigo_usuario);
					salida.put("MENSAJE", "¡Eliminación exitosa!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("MENSAJE", "Error, el usuario no pudo ser eliminado");
			} finally {
				List<Usuario> lista = usuarioService.listaUsuarioPorNombre("");
				salida.put("lista", lista);
			}

		} else {
			salida.put("MENSAJE", "Error, el usuario no existe");
		}
		
		return ResponseEntity.ok(salida);
	}
	
}
