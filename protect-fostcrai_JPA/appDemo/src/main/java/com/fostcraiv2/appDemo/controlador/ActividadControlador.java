package com.fostcraiv2.appDemo.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Actividad;
import com.fostcraiv2.appDemo.service.ActividadService;

@Controller
public class ActividadControlador {

	@Autowired
	private ActividadService service;
	
}
