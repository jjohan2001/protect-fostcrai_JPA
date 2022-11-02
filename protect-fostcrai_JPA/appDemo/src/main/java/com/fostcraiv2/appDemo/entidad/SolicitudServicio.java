package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.entidad.Servicio;

public class SolicitudServicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fechaServicio")
	private Date fechaServicio;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", referencedColumnName = "idCliente")
	private Cliente id_cliente_fk;
	
	@ManyToOne
	@JoinColumn(name = "id_servicio_fk", referencedColumnName = "idServicios")
	private Servicio id_servicio_fk;
	
	@ManyToMany(mappedBy = "listaSolicitudes")
	private List<Recreador> listRec;
	
}
