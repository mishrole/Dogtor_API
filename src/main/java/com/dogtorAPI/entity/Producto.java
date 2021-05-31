package com.dogtorAPI.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_producto")
public class Producto{

	@Column(name = "codigo_producto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_producto;

	@Column(name = "nombre_producto")
	private String nombre_producto;
	
	@Column(name = "descripcion_simple_producto")
	private String descripcion_simple_producto;
	
	@Column(name = "descripcion_html_producto")
	private String descripcion_html_producto;
	
	@Column(name = "precio_producto")
	private Double precio_producto;
	
	@Column(name = "stock_producto")
	private Integer stock_producto;
	
	@Column(name = "pedido_producto")
	private Integer pedido_producto;
	
	@Column(name = "serie_producto")
	private String serie_producto;
	
	@Column(name = "foto1_producto")
	private byte[] foto1_producto;
	
	@Column(name = "foto2_producto")
	private byte[] foto2_producto;
	
	@Column(name = "foto3_producto")
	private byte[] foto3_producto;
	
	@Column(name = "codigo_marca")
	private Integer codigo_marca;
	
	@Column(name = "codigo_categoria_producto")
	private Integer codigo_categoria_producto;
	
	@Column(name = "codigo_proveedor")
	private Integer codigo_proveedor;
	

	@ManyToOne
	@JoinColumn(name = "codigo_marca", insertable = false, updatable = false, nullable = false)
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria_producto", insertable = false, updatable = false, nullable = false)
	private CategoriaProducto categoria;
	
	@ManyToOne
	@JoinColumn(name = "codigo_proveedor", insertable = false, updatable = false, nullable = false)
	private Proveedor proveedor;

	
	

	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion_simple_producto() {
		return descripcion_simple_producto;
	}

	public void setDescripcion_simple_producto(String descripcion_simple_producto) {
		this.descripcion_simple_producto = descripcion_simple_producto;
	}

	public String getDescripcion_html_producto() {
		return descripcion_html_producto;
	}

	public void setDescripcion_html_producto(String descripcion_html_producto) {
		this.descripcion_html_producto = descripcion_html_producto;
	}

	public Double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(Double precio_producto) {
		this.precio_producto = precio_producto;
	}

	public Integer getStock_producto() {
		return stock_producto;
	}

	public void setStock_producto(Integer stock_producto) {
		this.stock_producto = stock_producto;
	}

	public Integer getPedido_producto() {
		return pedido_producto;
	}

	public void setPedido_producto(Integer pedido_producto) {
		this.pedido_producto = pedido_producto;
	}

	public String getSerie_producto() {
		return serie_producto;
	}

	public void setSerie_producto(String serie_producto) {
		this.serie_producto = serie_producto;
	}

	public byte[] getFoto1_producto() {
		return foto1_producto;
	}

	public void setFoto1_producto(byte[] foto1_producto) {
		this.foto1_producto = foto1_producto;
	}

	public byte[] getFoto2_producto() {
		return foto2_producto;
	}

	public void setFoto2_producto(byte[] foto2_producto) {
		this.foto2_producto = foto2_producto;
	}

	public byte[] getFoto3_producto() {
		return foto3_producto;
	}

	public void setFoto3_producto(byte[] foto3_producto) {
		this.foto3_producto = foto3_producto;
	}

	public Integer getCodigo_marca() {
		return codigo_marca;
	}

	public void setCodigo_marca(Integer codigo_marca) {
		this.codigo_marca = codigo_marca;
	}

	public Integer getCodigo_categoria_producto() {
		return codigo_categoria_producto;
	}

	public void setCodigo_categoria_producto(Integer codigo_categoria_producto) {
		this.codigo_categoria_producto = codigo_categoria_producto;
	}

	public Integer getCodigo_proveedor() {
		return codigo_proveedor;
	}

	public void setCodigo_proveedor(Integer codigo_proveedor) {
		this.codigo_proveedor = codigo_proveedor;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public CategoriaProducto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaProducto categoria) {
		this.categoria = categoria;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	
	
}
