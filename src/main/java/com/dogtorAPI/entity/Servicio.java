package com.dogtorAPI.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_servicio")
public class Servicio {
	
	@Column(name = "codigo_servicio")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_servicio;
	
	@Column(name = "codigo_tipo_servicio")
	private Integer codigo_tipo_servicio;
	
	@Column(name = "codigo_especialidad")
	private Integer codigo_especialidad;
	
	@Column(name = "codigo_especialista")
	private Integer codigo_especialista;
	
	@Column(name = "codigo_dia_semana")
	private Integer codigo_dia_semana;
	
	@Column(name = "inicio_turno_servicio")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date inicio_turno_servicio;
	
	@Column(name = "fin_turno_servicio")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date fin_turno_servicio;
	
	@Column(name = "nombre_servicio")
	private String nombre_servicio;
	
	@Column(name = "descripcion_servicio")
	private String descripcion_servicio;
	
	@Column(name = "precio_servicio")
	private Double precio_servicio;

	@Column(name = "limite_diario_servicio")
	private Integer limite_diario_servicio;
	
	@ManyToOne
	@JoinColumn(name = "codigo_especialista", insertable = false, updatable = false, nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_tipo_servicio", insertable = false, updatable = false, nullable = false)
	private TipoServicio tiposervicio;
	
	@ManyToOne
	@JoinColumn(name = "codigo_especialidad", insertable = false, updatable = false, nullable = false)
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "codigo_dia_semana", insertable = false, updatable = false, nullable = false)
	private DiaSemana diasemana;

	public Integer getCodigo_servicio() {
		return codigo_servicio;
	}

	public void setCodigo_servicio(Integer codigo_servicio) {
		this.codigo_servicio = codigo_servicio;
	}

	public Integer getCodigo_tipo_servicio() {
		return codigo_tipo_servicio;
	}

	public void setCodigo_tipo_servicio(Integer codigo_tipo_servicio) {
		this.codigo_tipo_servicio = codigo_tipo_servicio;
	}

	public Integer getCodigo_especialidad() {
		return codigo_especialidad;
	}

	public void setCodigo_especialidad(Integer codigo_especialidad) {
		this.codigo_especialidad = codigo_especialidad;
	}

	public Integer getCodigo_especialista() {
		return codigo_especialista;
	}

	public void setCodigo_especialista(Integer codigo_especialista) {
		this.codigo_especialista = codigo_especialista;
	}

	public Integer getCodigo_dia_semana() {
		return codigo_dia_semana;
	}

	public void setCodigo_dia_semana(Integer codigo_dia_semana) {
		this.codigo_dia_semana = codigo_dia_semana;
	}

	public Date getInicio_turno_servicio() {
		return inicio_turno_servicio;
	}

	public void setInicio_turno_servicio(Date inicio_turno_servicio) {
		this.inicio_turno_servicio = inicio_turno_servicio;
	}

	public Date getFin_turno_servicio() {
		return fin_turno_servicio;
	}

	public void setFin_turno_servicio(Date fin_turno_servicio) {
		this.fin_turno_servicio = fin_turno_servicio;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}

	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}

	public Double getPrecio_servicio() {
		return precio_servicio;
	}

	public void setPrecio_servicio(Double precio_servicio) {
		this.precio_servicio = precio_servicio;
	}

	public Integer getLimite_diario_servicio() {
		return limite_diario_servicio;
	}

	public void setLimite_diario_servicio(Integer limite_diario_servicio) {
		this.limite_diario_servicio = limite_diario_servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoServicio getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(TipoServicio tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public DiaSemana getDiasemana() {
		return diasemana;
	}

	public void setDiasemana(DiaSemana diasemana) {
		this.diasemana = diasemana;
	}
	
	
}
