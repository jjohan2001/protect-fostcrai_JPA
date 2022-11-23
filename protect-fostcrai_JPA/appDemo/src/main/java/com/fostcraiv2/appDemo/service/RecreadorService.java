package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.Genericos.GenericServiceAPI;
import com.fostcraiv2.appDemo.entidad.Recreador;

public interface RecreadorService extends GenericServiceAPI<Recreador, Long>{

	public List<Recreador> listarRecreadores();
	
	public Recreador guardarRecreador(Recreador recreador);
	
	public Recreador obtenerRecreadorporId(Long id);
	
	public Recreador actualizarRecreador(Recreador recreador);
	
	public void eliminarRecreador(Long id);
	
}
