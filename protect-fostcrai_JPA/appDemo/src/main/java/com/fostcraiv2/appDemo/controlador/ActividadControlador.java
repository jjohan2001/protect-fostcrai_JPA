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
public class ActividadControlador{

	@Autowired
	private ActividadService service;
	
	@GetMapping({ "actividades", "/" })
	public String listarActvidades(Model modelo) {
		modelo.addAttribute("actividaes", service.listarTodasLasActividades());
		return "actividades";
	}

	@GetMapping("/actividades/nueva")
	public String mostrarFromularioActividades(Model model) {
		Actividad actividad = new Actividad();
		model.addAttribute("actividad", actividad);
		return "crear_Actividad";
	}

	@PostMapping("/actividades")
	public String guardarActividad(@ModelAttribute("actividad") Actividad actividad) {
		service.guardarActividad(actividad);
		return "redirect:actividades";
	}

	@GetMapping("/actividades/editar/{id}")
	public String mostrarFormEditar(@PathVariable Long id, Model model) {
		model.addAttribute("actividad", service.obtenerActividadporId(id));
		return "editar_actividad";
	}

	@PostMapping("/actividades/{id}")
	public String actualizar(@PathVariable Long id, @ModelAttribute("acividad") Actividad actividad, Model model) {
		Actividad actividadExistente = service.obtenerActividadporId(id);
		actividadExistente.setId(id);
		actividadExistente.setActividades(actividad.getActividades());
		actividadExistente.setSolicitud_id(actividad.getSolicitud_id());

		service.actualizarActividad(actividadExistente);
		return "redirect:/actividades";
	}

	@GetMapping("/actividades/{id}")
	public String eliminarActividad(@PathVariable Long id) {
		service.eliminarActividad(id);
		return "redirect:/actividades";
	}
	
}
