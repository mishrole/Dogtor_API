package com.dogtorAPI.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.nio.file.Paths;
//import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.dogtorAPI.entity.Mascota;
import com.dogtorAPI.service.MascotaService;

import org.springframework.util.StringUtils;

@RestController
@RequestMapping("/rest/mascota")
public class MascotaController {
	
	@Value("${resourcesDir}")
	private String uploadFolder;
	
	@Autowired
	private MascotaService service;
	
	@RequestMapping("/listaMascotaPorNombre")
	@ResponseBody
	public List<Mascota> listaMascotaPorNombre(String nombre_mascota) {
		return service.listaMascotaPorNombre(nombre_mascota.trim());
	}
	
	@RequestMapping("/listaMascotaPorPropietario")
	@ResponseBody
	public List<Mascota> listaMascotaPorPropietario(Integer codigo_propietario) {
		return service.listaMascotaPorPropietario(codigo_propietario);
	}
	
	@RequestMapping("/listaMascotaPorPropietarioYNombre")
	@ResponseBody
	public List<Mascota> listaMascotaPorPropietarioYNombre(Integer codigo_propietario, String nombre_mascota) {
		return service.listaMascotaPorPropietarioYNombre(codigo_propietario, nombre_mascota);
	}
	
	@PostMapping("/registraMascotaConFoto")
	public @ResponseBody Map<String, Object> registraMascotaConFoto(@RequestParam(value = "codigo_propietario") Integer codigoPropietario,
			@RequestParam(value = "nombre_mascota") String nombreMascota, @RequestParam(value = "codigo_especie_mascota") Integer especieMascota,
			@RequestParam(value = "codigo_raza_mascota") Integer razaMascota, @RequestParam(value = "codigo_color_mascota") Integer colorMascota,
			@RequestParam(value = "codigo_sexo_mascota") Integer sexoMascota, @RequestParam(value = "fecha_nacimiento_mascota") String nacimientoMascota,
			@RequestParam(value = "codigo_identificacion_mascota", required = false) String identificacionMascota,
			@RequestParam(value = "codigo_cartilla_sanitaria", required = false) String cartillaMascota,
			Model model, HttpServletRequest request, final @RequestParam(value = "foto_mascota") MultipartFile file) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Mascota mascota = new Mascota();
		
		try {
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			
			try {
				
				File dir = new File(uploadDirectory);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
				// Setear archivo
				byte[] imageData = file.getBytes();
				mascota.setFoto_mascota(imageData);
				
				// Guardar localmente
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("MENSAJE", "El archivo no pudo ser procesado");
			}
			
			mascota.setCodigo_mascota(null);
			mascota.setCodigo_propietario(codigoPropietario);
			mascota.setNombre_mascota(nombreMascota);
			mascota.setCodigo_raza_mascota(razaMascota);
			mascota.setCodigo_especie_mascota(especieMascota);
			mascota.setCodigo_color_mascota(colorMascota);
			mascota.setCodigo_sexo_mascota(sexoMascota);
			mascota.setFecha_nacimiento_mascota(nacimientoMascota);
			mascota.setCodigo_identificacion_mascota(identificacionMascota);
			mascota.setCodigo_cartilla_sanitaria(cartillaMascota);
			mascota.setCodigo_visibilidad(1);
			
			Mascota objSalida = service.insertaMascota(mascota);
			
			if(objSalida == null) {
				salida.put("MENSAJE", "El registro no pudo ser completado");
			} else {
				
				if(fileName == null || fileName.contains("..")) {
					salida.put("MENSAJE", "El registro se completó sin la imagen");
				} else {
					salida.put("MENSAJE", "¡Registro exitoso!");
				}

			}
			
		} catch(Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "El registro no pudo ser completado");
		}
		
		return salida;
		
	}
	
	@PutMapping("/actualizaMascotaConFoto")
	public @ResponseBody Map<String, Object> actualizaMascotaConFoto(@RequestParam(value = "codigo_mascota") Integer codigoMascota, @RequestParam(value = "codigo_propietario", required = false) Integer codigoPropietario,
			@RequestParam(value = "nombre_mascota") String nombreMascota, @RequestParam(value = "codigo_especie_mascota") Integer especieMascota,
			@RequestParam(value = "codigo_raza_mascota") Integer razaMascota, @RequestParam(value = "codigo_color_mascota") Integer colorMascota,
			@RequestParam(value = "codigo_sexo_mascota") Integer sexoMascota, @RequestParam(value = "fecha_nacimiento_mascota") String nacimientoMascota,
			@RequestParam(value = "codigo_identificacion_mascota", required = false) String identificacionMascota,
			@RequestParam(value = "codigo_cartilla_sanitaria", required = false) String cartillaMascota, @RequestParam(value = "codigo_visibilidad") Integer codigoVisibilidad,
			Model model, HttpServletRequest request, final @RequestParam(value = "foto_mascota") MultipartFile file) {
				
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			Optional<Mascota> option = service.obtienePorId(codigoMascota);
			
			if(option.isPresent()) {
				option.ifPresent((Mascota result) -> {
					
					result.setNombre_mascota(nombreMascota);
					result.setFecha_nacimiento_mascota(nacimientoMascota);
					result.setCodigo_especie_mascota(especieMascota);
					result.setCodigo_raza_mascota(razaMascota);
					result.setCodigo_color_mascota(colorMascota);
					result.setCodigo_sexo_mascota(sexoMascota);
					result.setCodigo_visibilidad(codigoVisibilidad);
					result.setCodigo_cartilla_sanitaria(cartillaMascota);
					result.setCodigo_identificacion_mascota(identificacionMascota);
					
					try {
						String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						String filePath = Paths.get(uploadDirectory, fileName).toString();
						
						try {
							File dir = new File(uploadDirectory);
							if(!dir.exists()) {
								dir.mkdirs();
							}
							
							// Setear archivo
							byte[] imageData = file.getBytes();
							
							if(file.getBytes() != null && file.getSize() > 0 && imageData.length > 0) {
								result.setFoto_mascota(imageData);
							}
							
							// Guardar localmente
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
							stream.write(file.getBytes());
							stream.close();
						} catch (Exception e) {
							e.printStackTrace();
							salida.put("MENSAJE", "El archivo no es válido");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
						salida.put("MENSAJE", "El archivo no pudo ser procesado");
					} finally {
						Mascota objSalida = service.insertaMascota(result);
						
						if(objSalida == null) {
							salida.put("MENSAJE", "La actualización no pudo ser completada");
						} else {
							if(objSalida.getFoto_mascota() == null) {
								salida.put("MENSAJE", "La foto no pudo ser actualizada");
							} else {
								salida.put("MENSAJE", "¡Actualización exitosa!");
							}
						}
					}
				});

			} else {
				salida.put("MENSAJE", "Error, la mascota no existe");
			}
			
		} catch (Exception e) {
			salida.put("MENSAJE", "La actualización no pudo ser completada");
		}
		
		return salida;
		
	}
	
	@RequestMapping("/registraMascota")
	@ResponseBody
	public Map<String, Object> registra(Mascota objMascota) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		Mascota objSalida = null;
		
		try {
			objMascota.setCodigo_visibilidad(1); // Visibilidad 1 = Visible
			objSalida = service.insertaMascota(objMascota);
			
			if(objSalida == null) {
				salida.put("MENSAJE", "El registro no pudo ser completado");
			} else {
				salida.put("MENSAJE", "¡Registro exitoso!");
			}
			
		} catch (Exception e) {
			salida.put("MENSAJE", "El registro no pudo ser completado");
		} finally {
			List<Mascota> lista = service.listaMascotaPorNombre("");
			salida.put("lista", lista);
		}
		
		return salida;
	}
	
	@RequestMapping("/actualizaMascota")
	@ResponseBody
	public Map<String, Object> actualiza(Mascota objMascota) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			Optional<Mascota> option = service.obtienePorId(objMascota.getCodigo_mascota());
			
			if(option.isPresent()) {
				Mascota objSalida = service.insertaMascota(objMascota);
				
				if(objSalida == null) {
					salida.put("MENSAJE", "La actualización no pudo ser completada");
				} else {
					salida.put("MENSAJE", "¡Actualización exitosa!");
				}
			} else {
				salida.put("MENSAJE", "Error, la mascota no existe");
			}
			
		} catch (Exception e) {
			salida.put("MENSAJE", "La actualización no pudo ser completada");
		} finally {
			List<Mascota> lista = service.listaMascotaPorNombre("");
			salida.put("lista", lista);
		}
		
		return salida;
	}
	
	@RequestMapping("/actualizaVisibilidadMascota")
	@ResponseBody
	public Map<String, Object> actualizaVisibilidadMascota(Integer codigo_mascota, Integer codigo_visibilidad) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Mascota> option = service.obtienePorId(codigo_mascota);
		
		try {
			if(option.isPresent()) {
				option.ifPresent((Mascota result) -> {
					result.setCodigo_visibilidad(codigo_visibilidad);
					
					Mascota mascotaSalida = service.insertaMascota(result);
					
					if(mascotaSalida != null) {
						salida.put("MENSAJE", "El estado de la mascota ha sido modificado");
					}
				});
			} else {
				salida.put("MENSAJE", "Error, la mascota no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, la visibilidad no pudo ser actualizada");
		} finally {
			List<Mascota> lista = service.listaMascotaPorNombre("");
			salida.put("lista", lista);
		}
		
		return salida;
	}
	

	@RequestMapping("/eliminaMascota")
	@ResponseBody
	public Map<String, Object> elimina(Integer codigo_mascota) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Mascota> option = service.obtienePorId(codigo_mascota);
		
		try {
			if(option.isPresent()) {
				service.eliminaMascota(codigo_mascota);
				salida.put("MENSAJE", "¡Eliminación exitosa!");
			} else {
				salida.put("MENSAJE", "Error, la mascota no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, la mascota no pudo ser eliminada");
		} finally {
			List<Mascota> lista = service.listaMascotaPorNombre("");
			salida.put("lista", lista);
		}
		
		return salida;
	}

}
