package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fostcraiv2.appDemo.respository.ContratoRepository;

@Service
public class ContratoServieImpl implements ContratoService{

	@Autowired
	private ContratoRepository repositorio;
	
	@Override
	public List<Contrato> listarContratos() {
		return repositorio.findAll();
	}

	@Override
	public Contrato guardarContrato(Contrato contrato) {
		return repositorio.save(contrato);
	}

	@Override
	public Contrato obtenerContratoporId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Contrato actualizarContrato(Contrato contrato) {
		return repositorio.save(contrato);
	}

	@Override
	public void eliminarContrato(Long id) {
		repositorio.deleteById(id);
		
	}

}
