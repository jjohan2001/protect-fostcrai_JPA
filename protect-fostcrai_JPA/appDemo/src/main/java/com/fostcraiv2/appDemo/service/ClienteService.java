package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.entidad.Cliente;

public interface ClienteService {
	
	public List<Cliente> listarTodosLosClientes();
	
	public Cliente guardarCliente(Cliente cliente);
	
	public Cliente obtenerClienteporId(Long id);
	
	public Cliente actualizarCliente(Cliente cliente);
	
	public void eiminarCliente(Long id);
	
	
	

}
