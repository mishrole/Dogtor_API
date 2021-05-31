package com.dogtorAPI.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dogtorAPI.entity.Producto;
import com.dogtorAPI.service.ProductoService;

@Controller
public class ProductoController {
	
	@Value("${resourcesDir}")
	private String uploadFolder;
	
	@Autowired
	private ProductoService service;
	
	@RequestMapping("/verProducto")
	public String verRegistra() {
		return "crudProducto";
	}

	@RequestMapping("/listaProductoPorNombre")
	@ResponseBody
	public List<Producto> listaProductoPorNombre(String nombre_producto) {
		return service.listaProductoPorNombre(nombre_producto.trim());
	}
	
	@PostMapping("/registraProductoConFoto")
	public @ResponseBody Map<String, Object> registraProductoConFoto(@RequestParam(value = "nombre_producto") String nombre_producto,
			@RequestParam(value = "descripcion_simple_producto") String descripcion_simple_producto, @RequestParam(value = "descripcion_html_producto") String descripcion_html_producto,
			@RequestParam(value = "precio_producto") Double precio_producto, @RequestParam(value = "stock_producto") Integer stock_producto,
			@RequestParam(value = "pedido_producto") Integer pedido_producto, @RequestParam(value = "serie_producto") String serie_producto,
			@RequestParam(value = "codigo_marca", required = false) Integer codigo_marca,
			@RequestParam(value = "codigo_categoria_producto", required = false) Integer codigo_categoria_producto,
			@RequestParam(value = "codigo_proveedor", required = false) Integer codigo_proveedor,
			Model model, HttpServletRequest request, final @RequestParam(value = "foto1_producto") MultipartFile file,
			final @RequestParam(value = "foto2_producto") MultipartFile file1, final @RequestParam(value = "foto3_producto") MultipartFile file2) {

		Map<String, Object> salida = new HashMap<String, Object>();

		Producto producto = new Producto();

		try {
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
			String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());

			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String filePath1 = Paths.get(uploadDirectory, fileName1).toString();
			String filePath2 = Paths.get(uploadDirectory, fileName2).toString();

			try {

				File dir = new File(uploadDirectory);
				if(!dir.exists()) {
					dir.mkdirs();
				}

				// Setear archivo
				byte[] imageData = file.getBytes();
				producto.setFoto1_producto(imageData);

				byte[] imageData1 = file1.getBytes();
				producto.setFoto2_producto(imageData1);

				byte[] imageData2 = file2.getBytes();
				producto.setFoto3_producto(imageData2);

				// Guardar localmente
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(new File(filePath1)));
				BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(new File(filePath2)));
				stream.write(file.getBytes());
				stream1.write(file1.getBytes());
				stream2.write(file2.getBytes());
				stream.close();
				stream1.close();
				stream2.close();
			} catch (Exception e) {
				e.printStackTrace();
				salida.put("MENSAJE", "El archivo no pudo ser procesado");
			}

			producto.setCodigo_producto(null);
			producto.setNombre_producto(nombre_producto);
			producto.setDescripcion_simple_producto(descripcion_simple_producto);
			producto.setDescripcion_html_producto(descripcion_html_producto);
			producto.setPrecio_producto(precio_producto);
			producto.setStock_producto(stock_producto);
			producto.setPedido_producto(pedido_producto);
			producto.setSerie_producto(serie_producto);
			producto.setCodigo_marca(codigo_marca);
			producto.setCodigo_categoria_producto(codigo_categoria_producto);
			producto.setCodigo_proveedor(codigo_proveedor);

			Producto objSalida = service.insertaProducto(producto);

			if(objSalida == null) {
				salida.put("MENSAJE", "El registro no pudo ser completado");
			} else {

				if(fileName == null || fileName.contains("..") || fileName1 == null || fileName1.contains("..") || fileName2 == null || fileName2.contains("..")) {
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

	@PostMapping("/actualizaProductoConFoto")
	public @ResponseBody Map<String, Object> actualizaProductoConFoto(@RequestParam(value = "codigo_producto") Integer codigo_producto,
			@RequestParam(value = "nombre_producto") String nombre_producto,
			@RequestParam(value = "descripcion_simple_producto") String descripcion_simple_producto, @RequestParam(value = "descripcion_html_producto") String descripcion_html_producto,
			@RequestParam(value = "precio_producto") Double precio_producto, @RequestParam(value = "stock_producto") Integer stock_producto,
			@RequestParam(value = "pedido_producto") Integer pedido_producto, @RequestParam(value = "serie_producto") String serie_producto,
			@RequestParam(value = "codigo_marca", required = false) Integer codigo_marca,
			@RequestParam(value = "codigo_categoria_producto", required = false) Integer codigo_categoria_producto,
			@RequestParam(value = "codigo_proveedor", required = false) Integer codigo_proveedor,
			Model model, HttpServletRequest request, final @RequestParam(value = "foto1_producto") MultipartFile file,
			final @RequestParam(value = "foto2_producto") MultipartFile file1, final @RequestParam(value = "foto3_producto") MultipartFile file2) {

		Map<String, Object> salida = new HashMap<String, Object>();

		try {
			Optional<Producto> option = service.obtienePorId(codigo_producto);

			if(option.isPresent()) {
				option.ifPresent((Producto result) -> {

					result.setNombre_producto(nombre_producto);
					result.setDescripcion_simple_producto(descripcion_simple_producto);
					result.setDescripcion_html_producto(descripcion_html_producto);
					result.setPrecio_producto(precio_producto);
					result.setStock_producto(stock_producto);
					result.setPedido_producto(pedido_producto);
					result.setSerie_producto(serie_producto);
					result.setCodigo_marca(codigo_marca);
					result.setCodigo_categoria_producto(codigo_categoria_producto);
					result.setCodigo_proveedor(codigo_proveedor);

					try {
						String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						String fileName1 = StringUtils.cleanPath(file1.getOriginalFilename());
						String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
						String filePath = Paths.get(uploadDirectory, fileName).toString();
						String filePath1 = Paths.get(uploadDirectory, fileName1).toString();
						String filePath2 = Paths.get(uploadDirectory, fileName2).toString();

						try {
							File dir = new File(uploadDirectory);
							if(!dir.exists()) {
								dir.mkdirs();
							}

							// Setear archivo
							byte[] imageData = file.getBytes();
							byte[] imageData1 = file1.getBytes();
							byte[] imageData2 = file2.getBytes();

							if(file.getBytes() != null && file.getSize() > 0 && imageData.length > 0) {
								result.setFoto1_producto(imageData);
							}
							else if(file1.getBytes() != null && file1.getSize() > 0 && imageData1.length > 0){
								result.setFoto2_producto(imageData1);
							}
							else if(file2.getBytes() != null && file2.getSize() > 0 && imageData2.length > 0){
								result.setFoto2_producto(imageData2);
							}

							// Guardar localmente
							BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
							BufferedOutputStream stream1 = new BufferedOutputStream(new FileOutputStream(new File(filePath1)));
							BufferedOutputStream stream2 = new BufferedOutputStream(new FileOutputStream(new File(filePath2)));
							stream.write(file.getBytes());
							stream1.write(file1.getBytes());
							stream2.write(file2.getBytes());
							stream.close();
							stream1.close();
							stream2.close();
						} catch (Exception e) {
							e.printStackTrace();
							salida.put("MENSAJE", "El archivo no es válido");
						}

					} catch (Exception e) {
						e.printStackTrace();
						salida.put("MENSAJE", "El archivo no pudo ser procesado");
					} finally {
						Producto objSalida = service.insertaProducto(result);

						if(objSalida == null) {
							salida.put("MENSAJE", "La actualización no pudo ser completada");
						} else {
							if(objSalida.getFoto1_producto() == null) {
								salida.put("MENSAJE", "La foto no pudo ser actualizada");
							} else {
								salida.put("MENSAJE", "¡Actualización exitosa!");
							}
						}
					}
				});

			} else {
				salida.put("MENSAJE", "Error, el producto no existe");
			}

		} catch (Exception e) {
			salida.put("MENSAJE", "La actualización no pudo ser completada");
		}

		return salida;

	}

	@RequestMapping("/eliminaProducto")
	@ResponseBody
	public Map<String, Object> elimina(Integer codigo_producto) {
		Map<String, Object> salida = new HashMap<String, Object>();
		
		Optional<Producto> option = service.obtienePorId(codigo_producto);
		
		try {
			if(option.isPresent()) {
				service.eliminaProducto(codigo_producto);
				salida.put("MENSAJE", "¡Eliminación exitosa!");
			} else {
				salida.put("MENSAJE", "Error, el producto no existe");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Error, la mascota no pudo ser eliminada");
		} finally {
			List<Producto> lista = service.listaProducto();
			salida.put("lista", lista);
		}
		
		return salida;
	}

	
}
