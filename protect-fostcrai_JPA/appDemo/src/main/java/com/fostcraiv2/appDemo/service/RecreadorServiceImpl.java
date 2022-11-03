package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.respository.RecreadorRepository;

public class RecreadorServiceImpl implements RecreadorService{

	@Autowired
	private RecreadorRepository repositorio; 
	
	@Override
	public List<Recreador> listarRecreadores() {
		return repositorio.findAll();
	}

	@Override
	public Recreador guardarRecreador(Recreador recreador) {
		return repositorio.save(recreador);
	}

	@Override
	public Recreador encontraRecreadorporId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Recreador actualizarRecreador(Recreador recreador) {
		return repositorio.save(recreador);
	}

	@Override
	public void eliminarRecreador(Long id) {
		repositorio.deleteById(id);
	}

}
