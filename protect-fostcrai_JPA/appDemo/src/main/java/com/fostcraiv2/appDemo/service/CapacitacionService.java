package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.entidad.Capacitacion;

public interface CapacitacionService {

	public List<Capacitacion> listarCapacitaciones();
	
	public Capacitacion guardarCapacitacion(Capacitacion capacitacion);
	
	public Capacitacion obetenerCapacitacionporId(Long id);
	
	public Capacitacion actualizarCapacitacion(Capacitacion capacitacion);
	
	public void eliminarCapaciatacion(Long id);
}
