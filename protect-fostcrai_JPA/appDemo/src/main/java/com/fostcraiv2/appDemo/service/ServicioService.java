package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.Genericos.GenericServiceAPI;
import com.fostcraiv2.appDemo.entidad.Servicio;

public interface ServicioService extends GenericServiceAPI<Servicio, Long>{

	public List<Servicio> listarServicios();
	
	public Servicio guardarServicio(Servicio servicio);
	
	public Servicio obtenerServicioporId(Long id);
	
	public Servicio actualizarServicio(Servicio servicio);
	
	public void eliminarServicio(Long id);
	
}
