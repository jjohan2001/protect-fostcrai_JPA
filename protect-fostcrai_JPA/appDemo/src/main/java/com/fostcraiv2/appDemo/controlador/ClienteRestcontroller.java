package com.fostcraiv2.appDemo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.service.ClienteService;

@RestController
@RequestMapping(value = "/api/cliente/")
@CrossOrigin("*")
public class ClienteRestcontroller {

	
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/all")
	public List<Cliente> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value= "/find{id}")
	public Cliente find(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente obj= service.save(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id){
		Cliente cliente = service.get(id);
		if(cliente !=null) {
			service.delete(id);
		}else {
			return new ResponseEntity<Cliente> (cliente, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	
}
