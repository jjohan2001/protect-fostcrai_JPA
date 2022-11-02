package com.fostcraiv2.appDemo.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;

public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombreServicio")
	private String nombreServicio;
	
	@Column(name = "valor")
	private int valor;
	
	@OneToMany(mappedBy = "id_servicio_fk")
	private List<SolicitudServicio> ListSol;
	
	
}
