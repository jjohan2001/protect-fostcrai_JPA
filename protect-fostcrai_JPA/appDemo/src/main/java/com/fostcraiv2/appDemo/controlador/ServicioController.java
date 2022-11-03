package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fostcraiv2.appDemo.service.ServicioService;

@Controller
public class ServicioController {

	@Autowired
	private ServicioService service;
	
	@GetMapping({"/servicios", "/"})
	public String listarServicios(Model modelo) {
		modelo.addAttribute("servicios", service.listarServicios());
		
		return "servicios";
	}
}
