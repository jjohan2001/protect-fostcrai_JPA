package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fostcraiv2.appDemo.service.SolicitudServicioService;

@Controller
public class SolicitudServicioController {

	@Autowired
	private SolicitudServicioService service;
	
	@GetMapping({"/solicitudServicios", "/"})
	public String listarSolicitudes(Model modelo) {
		modelo.addAttribute("solicitudServicios", service.listarSolicitudes());
		return "solicitudServicios";
	}
	
}
