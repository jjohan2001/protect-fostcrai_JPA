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

import com.fostcraiv2.appDemo.entidad.Capacitacion;
import com.fostcraiv2.appDemo.service.CapacitacionService;

@RestController
@RequestMapping(value = "/api/capacitacion/")
@CrossOrigin("*")
public class CapacitacionRestcontroller {

	@Autowired
	private CapacitacionService serviceC;
	
	@GetMapping(value = "/all")
	public List<Capacitacion> geALL(){
		return serviceC.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public Capacitacion find(@PathVariable Long id) {
		return serviceC.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Capacitacion> save(@RequestBody Capacitacion capacitacion){
		Capacitacion obj = serviceC.save(capacitacion);
		return new ResponseEntity<Capacitacion>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Capacitacion> delete(@PathVariable Long id){
		Capacitacion capacitacion = serviceC.get(id);
		if(capacitacion != null) {
			serviceC.delete(id);
		}else {
			return new ResponseEntity<Capacitacion> (capacitacion, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Capacitacion>(capacitacion, HttpStatus.OK);
	}
	
}
