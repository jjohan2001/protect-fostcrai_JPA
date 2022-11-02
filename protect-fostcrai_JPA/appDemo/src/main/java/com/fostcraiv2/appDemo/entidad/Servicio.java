package com.fostcraiv2.appDemo.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombreServicio")
	private String nombreServicio;
	
	@Column(name = "valor")
	private int valor;
	
	@OneToMany(mappedBy = "id_servicio_fk")
	private List<SolicitudServicio> ListSol;;

	public Servicio(Long id, String nombreServicio, int valor, List<SolicitudServicio> listSol) {
		super();
		this.id = id;
		this.nombreServicio = nombreServicio;
		this.valor = valor;
		ListSol = listSol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
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
		return "Servicio [id=" + id + ", nombreServicio=" + nombreServicio + ", valor=" + valor + ", ListSol=" + ListSol
				+ "]";
	}
	
	
	
}
