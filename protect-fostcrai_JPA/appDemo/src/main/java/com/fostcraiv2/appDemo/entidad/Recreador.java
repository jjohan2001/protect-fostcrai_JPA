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
	@JoinColumn(name = "id_capacitacion_fk", referencedColumnName = "id")
	private Capacitacion id_capacitacion_fk;
	
	@ManyToOne
	@JoinColumn(name = "id_contratacion_fk", referencedColumnName = "id")
	private Contrato id_contratacion_fk;

	public Recreador() {
		
	}

	public Recreador(Long id, Date fechaNacimiento, int edad, List<SolicitudServicio> listaSolicitudes, Usuario usu,
			Capacitacion id_capacitacion_fk, Contrato id_contratacion_fk) {
		super();
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.listaSolicitudes = listaSolicitudes;
		this.usu = usu;
		this.id_capacitacion_fk = id_capacitacion_fk;
		this.id_contratacion_fk = id_contratacion_fk;
	}
	
	public Recreador( Date fechaNacimiento, int edad, List<SolicitudServicio> listaSolicitudes, Usuario usu,
			Capacitacion id_capacitacion_fk, Contrato id_contratacion_fk) {
		super();
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.listaSolicitudes = listaSolicitudes;
		this.usu = usu;
		this.id_capacitacion_fk = id_capacitacion_fk;
		this.id_contratacion_fk = id_contratacion_fk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public Capacitacion getId_capacitacion_fk() {
		return id_capacitacion_fk;
	}

	public void setId_capacitacion_fk(Capacitacion id_capacitacion_fk) {
		this.id_capacitacion_fk = id_capacitacion_fk;
	}

	public Contrato getId_contratacion_fk() {
		return id_contratacion_fk;
	}

	public void setId_contratacion_fk(Contrato id_contratacion_fk) {
		this.id_contratacion_fk = id_contratacion_fk;
	}

	@Override
	public String toString() {
		return "Recreador [id=" + id + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", listaSolicitudes="
				+ listaSolicitudes + ", usu=" + usu + ", id_capacitacion_fk=" + id_capacitacion_fk
				+ ", id_contratacion_fk=" + id_contratacion_fk + "]";
	}
	
	
}
