package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fostcraiv2.appDemo.service.RecreadorService;

@Controller
public class RecreadorController {

	@Autowired
	private RecreadorService service;
	
	@GetMapping({"/recreadores", "/"})
	public String listarRecreadores(Model modelo) {
		modelo.addAttribute("recreadores", service.listarRecreadores());
		return "recreadores";
	}
	
	
}
