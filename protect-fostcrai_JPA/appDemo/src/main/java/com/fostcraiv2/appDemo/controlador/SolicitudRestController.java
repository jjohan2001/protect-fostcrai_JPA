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

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.service.SolicitudServicioService;

@RestController
@RequestMapping(value = "/api/solicitudes/")
@CrossOrigin("*")
public class SolicitudRestController {

	@Autowired
	private SolicitudServicioService service;
	
	@GetMapping(value = "/all")
	public List<SolicitudServicio> getALL(){
		return service.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public SolicitudServicio find(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<SolicitudServicio> save(@RequestBody SolicitudServicio solicitud){
		SolicitudServicio obj = service.save(solicitud);
		return new ResponseEntity<SolicitudServicio>(solicitud, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete{id}")
	public ResponseEntity<SolicitudServicio> delete(@PathVariable Long id){
		SolicitudServicio solicitud = service.get(id);
		if(solicitud != null) {
			service.delete(id);
		}else {
			return new ResponseEntity<SolicitudServicio>(solicitud, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SolicitudServicio>(solicitud, HttpStatus.OK);
	}
	
}

