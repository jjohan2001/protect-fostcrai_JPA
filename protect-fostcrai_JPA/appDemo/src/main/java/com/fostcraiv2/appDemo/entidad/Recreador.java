package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import com.fostcraiv2.appDemo.entidad.Capacitacion;
import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.entidad.Usuario;

public class Recreador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "edad")
	private int edad;

	@ManyToMany
	@JoinTable(name = "programacionRec",
			joinColumns=@JoinColumn(name = "id_recreador_fk", nullable=false),
			inverseJoinColumns=@JoinColumn(name = "id_solicitud_fk", nullable=false))
	private List<SolicitudServicio> listaSolicitudes;
	
	@JoinColumn(name = "id_usuario_fk", unique=true)
	@OneToOne(cascade=CascadeType.ALL)
	private Usuario usu;
	
	@ManyToOne
	@JoinColumn(name = "id_capacitacion_fk", referencedColumnName = "idCapacitacion")
	private Capacitacion id_capacitacion_fk;
	
	@ManyToOne
	@JoinColumn(name = "id_contratacion_fk", referencedColumnName = "idContracion")
	private Contrato id_contratacion_fk;
	
}
