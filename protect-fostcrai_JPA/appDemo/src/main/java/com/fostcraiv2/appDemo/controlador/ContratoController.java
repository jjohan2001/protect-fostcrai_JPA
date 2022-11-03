package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fostcraiv2.appDemo.service.ContratoService;

@Controller
public class ContratoController {

	@Autowired
	private ContratoService service;
	
	@GetMapping({"/contratos", "/"})
	public String listarContratos(Model modelo) {
		modelo.addAttribute("contratos", service.listarContratos());
		return "contratos";
	}
	
}
