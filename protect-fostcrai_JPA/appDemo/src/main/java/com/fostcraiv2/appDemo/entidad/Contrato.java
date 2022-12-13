package com.fostcraiv2.appDemo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contratos")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fechaEntrada")
	private Date fecha_entrada;
	
	@Column(name = "horas")
	private String horas;
	
	@Column(name = "dias")
	private String dias;
	
	@JoinColumn(name = "id_recreador_fk", unique=true)
	@OneToOne(cascade=CascadeType.ALL)
	private Recreador id_recreador_fk;
	
	public Contrato() {
		
	}

	public Contrato(Long id, Date fecha_entrada, String horas, String dias, Recreador id_recreador_fk) {
		super();
		this.id = id;
		this.fecha_entrada = fecha_entrada;
		this.horas = horas;
		this.dias = dias;
		this.id_recreador_fk = id_recreador_fk;
	}

	public Contrato(Date fecha_entrada, String horas, String dias, Recreador id_recreador_fk) {
		super();
		this.fecha_entrada = fecha_entrada;
		this.horas = horas;
		this.dias = dias;
		this.id_recreador_fk = id_recreador_fk;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
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

	public Recreador getId_recreador_fk() {
		return id_recreador_fk;
	}

	public void setId_recreador_fk(Recreador id_recreador_fk) {
		this.id_recreador_fk = id_recreador_fk;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", fecha_entrada=" + fecha_entrada + ", horas=" + horas + ", dias=" + dias
				+ ", id_recreador_fk=" + id_recreador_fk + "]";
	}


	
}
