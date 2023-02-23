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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.entidad.Recreador;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@Table(name="solcitudServicios")
public class SolicitudServicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_servicio")
	private Date fecha_servicio;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk", referencedColumnName = "id")
	private Cliente id_cliente_fk;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servicio_fk")
	private Servicio id_servicio_fk;
	
	
	@ManyToMany(mappedBy = "listaSolicitudes")
	private List<Recreador> listRec;
	
	
	
	
	public SolicitudServicio() {
		
	}

	public SolicitudServicio(Long id, Date fecha_servicio, Cliente id_cliente_fk, Servicio id_servicio_fk,
			List<Recreador> listRec) {
		super();
		this.id = id;
		this.fecha_servicio = fecha_servicio;
		this.id_cliente_fk = id_cliente_fk;
		this.id_servicio_fk = id_servicio_fk;
		this.listRec = listRec;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_servicio() {
		return fecha_servicio;
	}

	public void setFecha_servicio(Date fecha_servicio) {
		this.fecha_servicio = fecha_servicio;
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

	public List<Recreador> getListRec() {
		return listRec;
	}

	public void setListRec(List<Recreador> listRec) {
		this.listRec = listRec;
	}

	@Override
	public String toString() {
		return "SolicitudServicio [id=" + id + ", fecha_servicio=" + fecha_servicio + ", id_cliente_fk=" + id_cliente_fk
				+ ", id_servicio_fk=" + id_servicio_fk + ", listRec=" + listRec + "]";
	}

	

}
