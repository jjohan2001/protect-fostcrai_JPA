package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fostcraiv2.appDemo.entidad.Capacitacion;
import com.fostcraiv2.appDemo.respository.CapacitacionRepository;

public class CapacitacionServiceImpl implements CapacitacionService{

	@Autowired
	private CapacitacionRepository repositorio;
	
	@Override
	public List<Capacitacion> listarCapacitaciones() {
		return repositorio.findAll();
	}

	@Override
	public Capacitacion guardarCapacitacion(Capacitacion capacitacion) {
		return repositorio.save(capacitacion);
	}

	@Override
	public Capacitacion obetenerCapacitacionporId(Long id) {
		return repositorio.findById(id).get();
	}
	
	@Override
	public Capacitacion actualizarCapacitacion(Capacitacion capacitacion) {
		return repositorio.save(capacitacion);
	}
	@Override
	public void eliminarCapaciatacion(Long id) {
		repositorio.deleteById(id);
		
	}



	
	
}
