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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.entidad.Usuario;
import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.Capacitacion;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name="recreadores")
public class Recreador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@Column(name = "edad")
	private int edad;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "programacionRec",
			joinColumns=@JoinColumn(name = "id_recreador_fk", nullable=false),
			inverseJoinColumns=@JoinColumn(name = "id_solicitud_fk", nullable=false))
	private List<SolicitudServicio> listaSolicitudes;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "id_usuario_fk", unique=true)
	@OneToOne(fetch = FetchType.LAZY)
	private Usuario id_usuario_fk;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_capacitacion_fk", referencedColumnName = "id")
	private Capacitacion id_capacitacion_fk;
	

	public Recreador() {
		
	}


	public Recreador(Long id, Date fecha_nacimiento, int edad, List<SolicitudServicio> listaSolicitudes,
			Usuario id_usuario_fk, Capacitacion id_capacitacion_fk) {
		super();
		this.id = id;
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.listaSolicitudes = listaSolicitudes;
		this.id_usuario_fk = id_usuario_fk;
		this.id_capacitacion_fk = id_capacitacion_fk;
	}

	public Recreador(Date fecha_nacimiento, int edad, List<SolicitudServicio> listaSolicitudes,
			Usuario id_usuario_fk, Capacitacion id_capacitacion_fk) {
		super();
		this.fecha_nacimiento = fecha_nacimiento;
		this.edad = edad;
		this.listaSolicitudes = listaSolicitudes;
		this.id_usuario_fk = id_usuario_fk;
		this.id_capacitacion_fk = id_capacitacion_fk;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public List<SolicitudServicio> getListaSolicitudes() {
		return listaSolicitudes;
	}


	public void setListaSolicitudes(List<SolicitudServicio> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}


	public Usuario getId_usuario_fk() {
		return id_usuario_fk;
	}


	public void setId_usuario_fk(Usuario id_usuario_fk) {
		this.id_usuario_fk = id_usuario_fk;
	}


	public Capacitacion getId_capacitacion_fk() {
		return id_capacitacion_fk;
	}


	public void setId_capacitacion_fk(Capacitacion id_capacitacion_fk) {
		this.id_capacitacion_fk = id_capacitacion_fk;
	}


	@Override
	public String toString() {
		return "Recreador [id=" + id + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad
				+ ", listaSolicitudes=" + listaSolicitudes + ", id_usuario_fk=" + id_usuario_fk
				+ ", id_capacitacion_fk=" + id_capacitacion_fk + "]";
	}
	
}
