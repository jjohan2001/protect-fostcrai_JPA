package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contratos")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fechaEntrada")
	private Date fechaEntrada;
	
	@Column(name = "horas")
	private String horas;
	
	@Column(name = "dias")
	private String dias;
	
	@OneToMany(mappedBy = "id_contratacion_fk")
	private List<Recreador> ListCon;
	
	public Contrato() {
		
	}

	public Contrato(Long id, Date fechaEntrada, String horas, String dias, List<Recreador> listCon) {
		super();
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.horas = horas;
		this.dias = dias;
		ListCon = listCon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public List<Recreador> getListCon() {
		return ListCon;
	}

	public void setListCon(List<Recreador> listCon) {
		ListCon = listCon;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", fechaEntrada=" + fechaEntrada + ", horas=" + horas + ", dias=" + dias
				+ ", ListCon=" + ListCon + "]";
	}

}
