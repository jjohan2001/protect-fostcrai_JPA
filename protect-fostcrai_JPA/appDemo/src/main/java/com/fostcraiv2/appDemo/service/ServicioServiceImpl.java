package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.respository.ServicioRepository;

public class ServicioServiceImpl implements ServicioService{

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
	
}
