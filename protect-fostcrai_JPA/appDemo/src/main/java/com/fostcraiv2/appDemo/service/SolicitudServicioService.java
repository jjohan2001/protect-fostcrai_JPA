package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;

public interface SolicitudServicioService {

	public List<SolicitudServicio> listarSolicitudes();
	
	public SolicitudServicio guardarSolictudes(SolicitudServicio solicitud);
	
	public SolicitudServicio obtenerSolicitudpoId(Long id);
	
	public SolicitudServicio actualiizarSolicitud(SolicitudServicio solicitud);
	
	public void eliminarsolicitud(Long id);
}
