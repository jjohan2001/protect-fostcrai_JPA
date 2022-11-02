package com.fostcraiv2.appDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.respository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository repositorio;
	
	@Override
	public List<Cliente> listarTodosLosClientes() {
		return repositorio.findAll();
	}

}
