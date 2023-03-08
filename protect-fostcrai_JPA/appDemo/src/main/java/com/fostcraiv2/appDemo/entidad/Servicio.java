package com.fostcraiv2.appDemo.entidad;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="servicios")
public class Servicio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7854096478858652265L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre_servicio")
	private String nombre_servicio;
	
	@Column(name = "valor")
	private int valor;
	
	@OneToMany(mappedBy = "id_servicio_fk")
	private List<SolicitudServicio> ListSol;
	
	public Servicio() {
		
	}

	
	
	public Servicio(Long id, String nombre_servicio, int valor, List<SolicitudServicio> listSol) {
		super();
		this.id = id;
		this.nombre_servicio = nombre_servicio;
		this.valor = valor;
		ListSol = listSol;
	}

	public Servicio(String nombre_servicio, int valor, List<SolicitudServicio> listSol) {
		super();
		this.nombre_servicio = nombre_servicio;
		this.valor = valor;
		ListSol = listSol;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(ListSol, id, nombre_servicio, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(ListSol, other.ListSol) && Objects.equals(id, other.id)
				&& Objects.equals(nombre_servicio, other.nombre_servicio) && valor == other.valor;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_servicio() {
		return nombre_servicio;
	}

	public void setNombre_servicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public List<SolicitudServicio> getListSol() {
		return ListSol;
	}

	public void setListSol(List<SolicitudServicio> listSol) {
		ListSol = listSol;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre_servicio=" + nombre_servicio + ", valor=" + valor + ", ListSol="
				+ ListSol + "]";
	}
	
}
