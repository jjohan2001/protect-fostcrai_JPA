package com.fostcraiv2.appDemo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String  nombre;
	
	@Column(name = "apellido", nullable = false, length = 50)
	private String  apellido;
	
	@Column(name = "cedula", nullable = false, length = 50, unique = true)
	private String  cedula;

	@Column(name = "celular", nullable = false, length = 50)
	private String  celular;
	
	@Column(name = "correo", nullable = false, length = 50, unique = true)
	private String  correo;
	
	@Column(name = "direccion", nullable = false, length = 50)
	private String  direccion;
	
	@Column(name = "password", nullable = false, length = 50)
	private String  password;
	
	@Column(name = "rol", nullable = false, length = 50)
	private String  rol;
	
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nombre, String apellido, String cedula, String celular, String correo,
			String direccion, String password, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.password = password;
		this.rol = rol;
	}
	
	public Usuario(String nombre, String apellido, String cedula, String celular, String correo,
			String direccion, String password, String rol) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.password = password;
		this.rol = rol;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", celular=" + celular + ", correo=" + correo + ", direccion=" + direccion + ", password=" + password
				+ ", rol=" + rol + "]";
	}
	
}

