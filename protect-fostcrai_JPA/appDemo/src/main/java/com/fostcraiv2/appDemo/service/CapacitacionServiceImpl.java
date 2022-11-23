package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.Genericos.GenericServiceImpl;
import com.fostcraiv2.appDemo.dao.Capacitaciondao;
import com.fostcraiv2.appDemo.entidad.Capacitacion;
import com.fostcraiv2.appDemo.respository.CapacitacionRepository;

@Service
public class CapacitacionServiceImpl extends GenericServiceImpl<Capacitacion, Long> implements CapacitacionService{

	@Autowired
	private Capacitaciondao capacitaciondao;
	
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

	@Override
	public CrudRepository<Capacitacion, Long> getDao() {
		return capacitaciondao;
	}



	
	
}
