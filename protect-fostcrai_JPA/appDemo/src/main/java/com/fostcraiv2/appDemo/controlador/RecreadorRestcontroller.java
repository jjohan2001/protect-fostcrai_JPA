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

import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.service.RecreadorService;

@RestController
@RequestMapping(value = "/api/recreadores/")
@CrossOrigin("*")
public class RecreadorRestcontroller {

	@Autowired
	private RecreadorService  service;
	
	@GetMapping(value = "/all")
	public List<Recreador> getALL(){
		return service.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public Recreador find(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Recreador> save(@RequestBody Recreador recreador){
		Recreador obj = service.save(recreador);
		return new ResponseEntity<Recreador>(recreador, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete")
	public ResponseEntity<Recreador> delete(@PathVariable Long id){
		Recreador recreador = service.get(id);
		if(recreador != null) {
			service.delete(id);
		}else {
			return new ResponseEntity<Recreador> (recreador, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Recreador>(recreador, HttpStatus.OK);
	}
	
	
}
