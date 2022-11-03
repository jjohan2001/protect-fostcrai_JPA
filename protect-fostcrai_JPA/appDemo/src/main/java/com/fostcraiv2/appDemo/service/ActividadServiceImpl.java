package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fostcraiv2.appDemo.entidad.Actividad;
import com.fostcraiv2.appDemo.respository.ActividadRepository;

public class ActividadServiceImpl implements ActividadService{

	@Autowired
	private ActividadRepository repositorio;
	
	@Override
	public List<Actividad> listarTodasLasActividades() {
		return repositorio.findAll();
	}

	@Override
	public Actividad guardarActividad(Actividad actividad) {
		return repositorio.save(actividad);
	}

	@Override
	public Actividad obtenerActividadporId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarActividad(Long id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public Actividad actualizarActividad(Actividad actividad) {
		return repositorio.save(actividad);
	}

	
	
}
