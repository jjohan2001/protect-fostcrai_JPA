package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.Genericos.GenericServiceImpl;
import com.fostcraiv2.appDemo.dao.Actividadao;
import com.fostcraiv2.appDemo.entidad.Actividad;
import com.fostcraiv2.appDemo.respository.ActividadRepository;

@Service
public class ActividadServiceImpl extends GenericServiceImpl<Actividad, Long> implements ActividadService{

	@Autowired
	private Actividadao actividadao;
	
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

	@Override
	public CrudRepository<Actividad, Long> getDao() {
		return actividadao;
	}

	
	
}
