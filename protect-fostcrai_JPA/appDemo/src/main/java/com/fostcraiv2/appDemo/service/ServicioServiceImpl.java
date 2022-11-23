package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.Genericos.GenericServiceImpl;
import com.fostcraiv2.appDemo.dao.Serviciodao;
import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.respository.ServicioRepository;

@Service
public class ServicioServiceImpl extends GenericServiceImpl<Servicio, Long> implements ServicioService{

	@Autowired
	private Serviciodao serviciodao;
	
	@Autowired
	private ServicioRepository repositorio;
	
	@Override
	public List<Servicio> listarServicios() {
		return repositorio.findAll();
	}

	@Override
	public Servicio guardarServicio(Servicio servicio) {
		return repositorio.save(servicio);
	}

	@Override
	public Servicio obtenerServicioporId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Servicio actualizarServicio(Servicio servicio) {
		return repositorio.save(servicio);
	}

	@Override
	public void eliminarServicio(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CrudRepository<Servicio, Long> getDao() {
		return serviciodao;
	}
	
}
