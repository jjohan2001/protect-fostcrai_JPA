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

import com.fostcraiv2.appDemo.entidad.Usuario;
import com.fostcraiv2.appDemo.service.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuarios/")
@CrossOrigin("*")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/all")
	public List<Usuario> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "/find{id}")
	public Usuario find(@PathVariable Long id) {
		return service.get(id);
	}
	
	
	@PostMapping(value = "/save")
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		Usuario obj = service.save(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Usuario> delete(@PathVariable Long id){
		Usuario usuario = service.get(id);
		if(usuario != null) {
			service.delete(id);
		}else {
			return new ResponseEntity<Usuario> (usuario, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	
	
}
