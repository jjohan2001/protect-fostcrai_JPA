package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.entidad.Recreador;

@Entity
@Table(name="solcitudServicios")
public class SolicitudServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_Servicio")
	private Date fecha_Servicio;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", referencedColumnName = "id")
	private Cliente id_cliente_fk;
	
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "id_servicio_fk", referencedColumnName = "id")
	private Servicio id_servicio_fk;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "listaSolicitudes")
	private List<Recreador> listRec;
	
	public SolicitudServicio() {
		
	}

	public SolicitudServicio(Long id, Date fechaServicio, Cliente id_cliente_fk, Servicio id_servicio_fk) {
		super();
		this.id = id;
		this.fecha_Servicio = fechaServicio;
		this.id_cliente_fk = id_cliente_fk;
		this.id_servicio_fk = id_servicio_fk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaServicio() {
		return fecha_Servicio;
	}

	public void setFechaServicio(Date fechaServicio) {
		this.fecha_Servicio = fechaServicio;
	}

	public Cliente getId_cliente_fk() {
		return id_cliente_fk;
	}

	public void setId_cliente_fk(Cliente id_cliente_fk) {
		this.id_cliente_fk = id_cliente_fk;
	}

	public Servicio getId_servicio_fk() {
		return id_servicio_fk;
	}

	public void setId_servicio_fk(Servicio id_servicio_fk) {
		this.id_servicio_fk = id_servicio_fk;
	}

	@Override
	public String toString() {
		return "SolicitudServicio [id=" + id + ", fechaServicio=" + fecha_Servicio + ", id_cliente_fk=" + id_cliente_fk
				+ ", id_servicio_fk=" + id_servicio_fk + "]";
	}

}
