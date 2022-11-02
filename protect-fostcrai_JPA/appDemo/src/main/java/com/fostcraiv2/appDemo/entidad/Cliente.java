package com.fostcraiv2.appDemo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false,length = 50)
	private String nombre;
	
	@Column(name = "apellido", nullable = false,length = 50)
	private String apellido;
	
	@Column(name = "celular", nullable = false,length = 50)
	private String celular;
	
	@Column(name = "correo", nullable = false,length = 50,unique = true)
	private String correo;
	
	@Column(name = "direccion", nullable = false,length = 50)
	private String direccion;
	
	@Column(name = "fecha_del_evento", nullable = false,length = 50)
	private String fecha_del_evento;
	
	
	
	public Cliente(){
		
	}

	public Cliente(Long id, String nombre, String apellido, String celular, String correo, String direccion,
			String fecha_del_evento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.fecha_del_evento = fecha_del_evento;
	}
	
	public Cliente(String nombre, String apellido, String celular, String correo, String direccion,
			String fecha_del_evento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.fecha_del_evento = fecha_del_evento;
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

	public String getFecha_del_evento() {
		return fecha_del_evento;
	}

	public void setFecha_del_evento(String fecha_del_evento) {
		this.fecha_del_evento = fecha_del_evento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", celular=" + celular
				+ ", correo=" + correo + ", direccion=" + direccion + ", fecha_del_evento=" + fecha_del_evento + "]";
	}
	
	
}
