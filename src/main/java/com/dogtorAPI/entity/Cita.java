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

@Entity
@Table(name = "tb_cita")
public class Cita {
	
	@Column(name = "codigo_cita")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo_cita;
	
	@Column(name = "fecha_solicitud_cita")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_solicitud_cita;
	
	@Column(name = "fecha_programada_cita")
	private String fecha_programada_cita;

	@Column(name = "codigo_servicio")
	private Integer codigo_servicio;
	
	@Column(name = "codigo_propietario")
	private Integer codigo_propietario;
	
	@Column(name = "codigo_mascota")
	private Integer codigo_mascota;
	
	@Column(name = "codigo_estado_cita")
	private Integer codigo_estado_cita;
	
	@ManyToOne
	@JoinColumn(name = "codigo_servicio", insertable = false, updatable = false, nullable = false)
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name = "codigo_propietario", insertable = false, updatable = false, nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "codigo_mascota", insertable = false, updatable = false, nullable = false)
	private Mascota mascota;
	
	@ManyToOne
	@JoinColumn(name = "codigo_estado_cita", insertable = false, updatable = false, nullable = false)
	private EstadoCita estado;
	
	@Column(name = "motivo_cita")
	private String motivo_cita;

	public Integer getCodigo_cita() {
		return codigo_cita;
	}

	public void setCodigo_cita(Integer codigo_cita) {
		this.codigo_cita = codigo_cita;
	}

	public Date getFecha_solicitud_cita() {
		return fecha_solicitud_cita;
	}

	public void setFecha_solicitud_cita(Date fecha_solicitud_cita) {
		this.fecha_solicitud_cita = fecha_solicitud_cita;
	}

	public String getFecha_programada_cita() {
		return fecha_programada_cita;
	}

	public void setFecha_programada_cita(String fecha_programada_cita) {
		this.fecha_programada_cita = fecha_programada_cita;
	}

	public Integer getCodigo_servicio() {
		return codigo_servicio;
	}

	public void setCodigo_servicio(Integer codigo_servicio) {
		this.codigo_servicio = codigo_servicio;
	}

	public Integer getCodigo_propietario() {
		return codigo_propietario;
	}

	public void setCodigo_propietario(Integer codigo_propietario) {
		this.codigo_propietario = codigo_propietario;
	}

	public Integer getCodigo_mascota() {
		return codigo_mascota;
	}

	public void setCodigo_mascota(Integer codigo_mascota) {
		this.codigo_mascota = codigo_mascota;
	}

	public Integer getCodigo_estado_cita() {
		return codigo_estado_cita;
	}

	public void setCodigo_estado_cita(Integer codigo_estado_cita) {
		this.codigo_estado_cita = codigo_estado_cita;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public EstadoCita getEstado() {
		return estado;
	}

	public void setEstado(EstadoCita estado) {
		this.estado = estado;
	}

	public String getMotivo_cita() {
		return motivo_cita;
	}

	public void setMotivo_cita(String motivo_cita) {
		this.motivo_cita = motivo_cita;
	}

}
