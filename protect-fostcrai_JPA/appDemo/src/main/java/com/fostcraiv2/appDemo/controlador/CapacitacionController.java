package com.fostcraiv2.appDemo.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Capacitacion;
import com.fostcraiv2.appDemo.service.CapacitacionService;

@Controller
public class CapacitacionController {

	@Autowired
	private CapacitacionService service;
	
	@GetMapping({"/capacitaciones", "/"})
	public String listarCapacitaciones(Model modelo) {
		modelo.addAttribute("capacitaciones", service.listarCapacitaciones());
		return "capacitaciones";
	}
	
	@GetMapping({"/capacitaciones/nuevo"})
	public String formularioReistroCapacitacion(Model modelo) {
		Capacitacion capacitacion= new Capacitacion();
		modelo.addAttribute("capacitacion", capacitacion);
		return "nuevoFormulario";
	}
	
	@PostMapping("/capacitaciones")
	public String guardarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion) {
		service.guardarCapacitacion(capacitacion);
		
		return "redirect:capacitaciones";
	}
	
	@GetMapping("capacitaciones/editar/{id}")
	public String fromularioEditarCapacitacion(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("capacitacion", service.obetenerCapacitacionporId(id));
		return "formularioEditarCapacitacion";
	}
	
	@PostMapping("capacitaciones/{id}")
	public String actualizarCapacitacion(@PathVariable Long id, @ModelAttribute("capacitacion") Capacitacion capacitacion, Model modelo) {
		Capacitacion capacitacionExistenete = service.obetenerCapacitacionporId(id);
		capacitacionExistenete.setId(id);
		capacitacionExistenete.setFechaCapacitacion(capacitacion.getFechaCapacitacion());
		capacitacionExistenete.setHorasCapacitacion(capacitacion.getHorasCapacitacion());
		
		return "redirect:capacitaciones";
	}
	
	@GetMapping("capacitaciones/{id}")
	public String eliminarCapacitacion(@PathVariable Long id) {
		service.eliminarCapaciatacion(id);
		return "redirect:capacitaciones";
	}
	
}
