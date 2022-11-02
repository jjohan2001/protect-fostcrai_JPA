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
	
	@JoinColumn(name = "solicitud_id", unique=true)
	@OneToOne(cascade=CascadeType.ALL)
	private SolicitudServicio solicitudes;
	
}
