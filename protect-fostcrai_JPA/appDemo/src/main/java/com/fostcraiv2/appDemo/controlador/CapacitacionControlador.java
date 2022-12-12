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
public class CapacitacionControlador {

	@Autowired
	private CapacitacionService service;
	
	@GetMapping({"capacitaciones/", "/"})
	public String listarCapacitaciones(Model modelo) {
		modelo.addAttribute("capacitaciones", service.listarCapacitaciones());
		return "capacitaaciones";
	}
	
	@GetMapping("/capacitaciones/nueva")
	public String mostrarformularioCapacitacion(Model modelo) {
		Capacitacion capacitacion = new Capacitacion();
		modelo.addAttribute("capacitacion", capacitacion);
		return "crear_capacitacion";
		
	}
	
	@PostMapping("/capacitaciones")
	public String guadarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion) {
		service.guardarCapacitacion(capacitacion);
		return "redirect:capacitacion";
	}
	
	@GetMapping("/capacitaciones/editar/{id}")
	public String formularioEditarCapacitacion(@PathVariable Long id, Model modelo ) {
		modelo.addAttribute("capacitacion", service.obetenerCapacitacionporId(id));
		return "editar_capacitacion";
	}
	
	@PostMapping("/capactacion/{id}")
	public String actualizarCapacitacion(@PathVariable Long id, @ModelAttribute("capacitacion") Capacitacion capacitacion, Model modelo) {
		Capacitacion capacitacionExistente = service.obetenerCapacitacionporId(id);
		capacitacionExistente.setId(id);
		capacitacionExistente.setFecha_capacitacion(capacitacion.getFecha_capacitacion());
		capacitacionExistente.setHoras_capacitacion(capacitacion.getHoras_capacitacion());
		
		service.actualizarCapacitacion(capacitacionExistente);
		return "redirect:capacitacion";
	}
	
	@GetMapping("/capacitaciones/{id}")
	public String eliminarCapacitacion(@PathVariable Long id) {
		service.eliminarCapaciatacion(id);
		return "redirect:capacitacion";
	}
	
}
