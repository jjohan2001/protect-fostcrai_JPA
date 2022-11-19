package com.fostcraiv2.appDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.fostcraiv2.appDemo.Genericos.GenericServiceImpl;
import com.fostcraiv2.appDemo.dao.Clientedao;
import com.fostcraiv2.appDemo.entidad.Cliente;


@Service
public class ClienteServiceImpl  extends GenericServiceImpl<Cliente, Long> implements ClienteService{

	@Autowired
	private Clientedao clientedao;
	
	@Override
	public CrudRepository<Cliente, Long> getDao(){
		return clientedao;
	}
}
