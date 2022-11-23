package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.Genericos.GenericServiceImpl;
import com.fostcraiv2.appDemo.dao.SolicitudServiciodao;
import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.respository.SolicitudServicioRepository;

@Service
public class SolcitiduServicioServiceImpl extends GenericServiceImpl<SolicitudServicio, Long> implements SolicitudServicioService{

	@Autowired
	private SolicitudServiciodao solicituddao;
	
	@Autowired
	private SolicitudServicioRepository repositorio;
	
	@Override
	public List<SolicitudServicio> listarSolicitudes() {
		return repositorio.findAll();
	}

	@Override
	public SolicitudServicio guardarSolictudes(SolicitudServicio solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public SolicitudServicio obtenerSolicitudpoId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public SolicitudServicio actualiizarSolicitud(SolicitudServicio solicitud) {
		return repositorio.save(solicitud);
	}

	@Override
	public void eliminarsolicitud(Long id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public CrudRepository<SolicitudServicio, Long> getDao() {
		return solicituddao;
	}

	
	
	
}
