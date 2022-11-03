package com.fostcraiv2.appDemo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;

@Entity
@Table(name="actividades")
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "actividades", length = 50)
	private String actividades;
	
	@Column(name = "horas", length = 50)
	private String horas;	
	
	@JoinColumn(name = "solicitud_id", unique=true)
	@OneToOne(cascade=CascadeType.ALL)
	private SolicitudServicio solicitudes;
	
	public Actividad() {
		
	}

	public Actividad(Long id, String actividades, SolicitudServicio solicitudes) {
		super();
		this.id = id;
		this.actividades = actividades;
		this.solicitudes = solicitudes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public SolicitudServicio getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(SolicitudServicio solicitudes) {
		this.solicitudes = solicitudes;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", actividades=" + actividades + ", horas=" + horas + ", solicitudes="
				+ solicitudes + "]";
	}

	
	
	
	
}
