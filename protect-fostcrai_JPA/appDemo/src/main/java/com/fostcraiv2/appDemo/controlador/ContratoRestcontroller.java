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

import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.service.ContratoService;
import com.fostcraiv2.appDemo.service.RecreadorService;

@RestController
@RequestMapping(value = "/api/contrato/")
@CrossOrigin("*")
public class ContratoRestcontroller {

	@Autowired
	private ContratoService service;
	
	@Autowired
	private RecreadorService serviceR;
	
	@GetMapping(value = "/all")
	public List<Contrato> getALL(){
		return service.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public Contrato find(@PathVariable Long id) {
		return service.get(id);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Contrato> save(@RequestBody Contrato contrato){
		Contrato obj = service.save(contrato);
		return new ResponseEntity<Contrato>(obj, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/delete{id}")
	public ResponseEntity <Contrato> delete(@PathVariable Long id){
		Contrato contrato = service.get(id);
		if(contrato != null) {
			service.delete(id);
		}else {
			return new ResponseEntity<Contrato> (contrato, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Contrato>(contrato, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listarRecreadores")
	@ResponseBody
	public List<Recreador> listarRecreadores (){
		List<Recreador> listar = serviceR.getAll();
		return listar;
	}
	
}
