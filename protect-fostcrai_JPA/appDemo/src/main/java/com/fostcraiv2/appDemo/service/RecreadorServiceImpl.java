package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.Genericos.GenericServiceImpl;
import com.fostcraiv2.appDemo.dao.Recreadordao;
import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.respository.RecreadorRepository;

@Service
public class RecreadorServiceImpl extends GenericServiceImpl<Recreador, Long> implements RecreadorService{
	
	@Autowired
	private Recreadordao recreadordao;
	
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
	public Recreador obtenerRecreadorporId(Long id) {
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

	@Override
	public CrudRepository<Recreador, Long> getDao() {
		return recreadordao;
	}

}
