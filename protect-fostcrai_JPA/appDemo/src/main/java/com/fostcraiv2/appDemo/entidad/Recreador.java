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
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.entidad.Usuario;
import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fostcraiv2.appDemo.entidad.Capacitacion;

@Entity
@Table(name="recreadores")
public class Recreador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fechaNacimiento")
	private Date fechaEvento;
	
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
	@JoinColumn(name = "id_capacitacion_fk", referencedColumnName = "id")
	private Capacitacion id_capacitacion_fk;
	
	@ManyToOne
	@JoinColumn(name = "id_contratacion_fk", referencedColumnName = "id")
	private Contrato id_contratacion_fk;

	
	
	
	
}
