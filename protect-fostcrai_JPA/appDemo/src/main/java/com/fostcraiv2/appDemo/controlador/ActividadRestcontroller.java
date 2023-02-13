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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fostcraiv2.appDemo.entidad.Actividad;
import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.service.ActividadService;
import com.fostcraiv2.appDemo.service.SolicitudServicioService;

@RestController
@RequestMapping(value = "/api/actividades/")
@CrossOrigin("*")
public class ActividadRestcontroller {
	
	@Autowired
	private SolicitudServicioService serviceSoli;
	
	@Autowired
	private ActividadService serviceA;
	
	@GetMapping(value = "/all")
	public List<Actividad> geALL(){
		return serviceA.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public Actividad find(@PathVariable Long id) {
		return serviceA.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Actividad> save(@RequestBody Actividad actividad){
		Actividad obj = serviceA.save(actividad);
		return new ResponseEntity<Actividad>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete{id}")
	public ResponseEntity<Actividad> delete(@PathVariable Long id){
		Actividad actividad = serviceA.get(id);
		if(actividad != null) {
			serviceA.delete(id);
		}else {
			return new ResponseEntity<Actividad> (actividad, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Actividad>(actividad, HttpStatus.OK);
	}
	
	
	@RequestMapping( value = "/listaSolicitudes")
	@ResponseBody
	public List<SolicitudServicio> listaSolici(){
		List<SolicitudServicio> lista = serviceSoli.listarSolicitudes();
		return lista;
	}
	
}
