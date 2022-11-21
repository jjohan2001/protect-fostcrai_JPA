package com.fostcraiv2.appDemo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
    
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 50)
	private String nombre;
	
	@Column(name = "apellido",length = 50)
	private String apellido;
	
	@Column(name = "cedula", length = 50)
	private String cedula;
	
	@Column(name = "celular", length = 50)
	private String celular;
	
	@Column(name = "correo", length = 50,unique = true)
	private String correo;
	
	@Column(name = "direccion",length = 50)
	private String direccion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fechaEvento")
	private Date fechaEvento;
	
	
	
	public Cliente(){
		
	}



	public Cliente(Long id, String nombre, String apellido, String cedula, String celular, String correo,
			String direccion, Date fechaEvento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaEvento = fechaEvento;
	}

	public Cliente(String nombre, String apellido, String cedula, String celular, String correo,
			String direccion, Date fechaEvento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.fechaEvento = fechaEvento;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getCedula() {
		return cedula;
	}



	public void setCedula(String cedula) {
		this.cedula = cedula;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Date getFechaEvento() {
		return fechaEvento;
	}



	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", celular=" + celular + ", correo=" + correo + ", direccion=" + direccion + ", fechaEvento="
				+ fechaEvento + "]";
	}	
	
	
}
