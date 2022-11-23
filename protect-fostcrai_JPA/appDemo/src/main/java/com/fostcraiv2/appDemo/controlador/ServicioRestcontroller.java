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

import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.service.ServicioService;

@RestController
@RequestMapping(value = "/api/servicio/")
@CrossOrigin("*")
public class ServicioRestcontroller {

	@Autowired
	private ServicioService service;
	
	@GetMapping(value = "/all")
	public List<Servicio> getALL(){
		return service.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public Servicio find(@PathVariable Long id){
		return service.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Servicio> save(@RequestBody Servicio servicio){
		Servicio obj = service.save(servicio);
		return new ResponseEntity<Servicio>(servicio, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete{id}")
	public ResponseEntity<Servicio> delete(@PathVariable Long id){
		Servicio servicio = service.get(id);
		if(servicio != null) {
			service.delete(id);
		}else {
			return new ResponseEntity<Servicio>(servicio, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Servicio>(servicio, HttpStatus.OK);
	}
	
}
