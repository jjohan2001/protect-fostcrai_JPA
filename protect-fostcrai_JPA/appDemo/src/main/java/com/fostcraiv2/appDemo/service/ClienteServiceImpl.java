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

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return repositorio.save(cliente);
	}

	@Override
	public Cliente obtenerClienteporId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) {
		return repositorio.save(cliente);
	}

	@Override
	public void eiminarCliente(Long id) {
		repositorio.deleteById(id);
	}

}
