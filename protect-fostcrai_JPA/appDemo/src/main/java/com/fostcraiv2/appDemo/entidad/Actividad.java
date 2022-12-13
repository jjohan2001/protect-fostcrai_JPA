package com.fostcraiv2.appDemo.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.SolicitudServicio;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name="actividades")
public class Actividad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "actividades", length = 50)
	private String actividades;
	
	@Column(name = "horas")
	private int horas;	
	
	@OneToOne
	@JoinColumn(name = "solicitud_id",referencedColumnName = "id")
	private SolicitudServicio solicitud_id;
	
	public Actividad() {
		
	}

	public Actividad(Long id, String actividades, int horas, SolicitudServicio solicitud_id) {
		super();
		this.id = id;
		this.actividades = actividades;
		this.horas = horas;
		this.solicitud_id = solicitud_id;
	}
	
	public Actividad(String actividades, int horas, SolicitudServicio solicitud_id) {
		super();
		this.actividades = actividades;
		this.horas = horas;
		this.solicitud_id = solicitud_id;
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public SolicitudServicio getSolicitud_id() {
		return solicitud_id;
	}

	public void setSolicitud_id(SolicitudServicio solicitud_id) {
		this.solicitud_id = solicitud_id;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", actividades=" + actividades + ", horas=" + horas + ", solicitud_id="
				+ solicitud_id + "]";
	}
	
	
	
}
