package com.fostcraiv2.appDemo.entidad;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fostcraiv2.appDemo.entidad.Recreador;

@Entity
@Table(name="capacitaciones")
public class Capacitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fechaCapacitacion")
	private Date fechaCapacitacion;
	
	@Column(name = "horasCapacitacion")
	private String horasCapacitacion;
	
	@OneToMany(mappedBy = "id_capacitacion_fk")
	private List<Recreador> ListSer;

	public Capacitacion(Long id, Date fechaCapacitacion, String horasCapacitacion, List<Recreador> listSer) {
		super();
		this.id = id;
		this.fechaCapacitacion = fechaCapacitacion;
		this.horasCapacitacion = horasCapacitacion;
		ListSer = listSer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCapacitacion() {
		return fechaCapacitacion;
	}

	public void setFechaCapacitacion(Date fechaCapacitacion) {
		this.fechaCapacitacion = fechaCapacitacion;
	}

	public String getHorasCapacitacion() {
		return horasCapacitacion;
	}

	public void setHorasCapacitacion(String horasCapacitacion) {
		this.horasCapacitacion = horasCapacitacion;
	}

	public List<Recreador> getListSer() {
		return ListSer;
	}

	public void setListSer(List<Recreador> listSer) {
		ListSer = listSer;
	}

	@Override
	public String toString() {
		return "Capacitacion [id=" + id + ", fechaCapacitacion=" + fechaCapacitacion + ", horasCapacitacion="
				+ horasCapacitacion + ", ListSer=" + ListSer + "]";
	}

}
