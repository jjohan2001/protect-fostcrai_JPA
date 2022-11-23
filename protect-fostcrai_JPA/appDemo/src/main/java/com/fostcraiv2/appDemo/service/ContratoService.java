package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.Genericos.GenericServiceAPI;
import com.fostcraiv2.appDemo.entidad.Contrato;

public interface ContratoService extends GenericServiceAPI<Contrato, Long>{

	public List<Contrato> listarContratos();
	
	public Contrato guardarContrato(Contrato contrato);
	
	public Contrato obtenerContratoporId(Long id);
	
	public Contrato actualizarContrato(Contrato contrato);
	
	public void eliminarContrato(Long id);
}
