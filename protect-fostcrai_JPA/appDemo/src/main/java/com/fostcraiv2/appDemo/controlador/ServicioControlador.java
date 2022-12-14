package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Servicio;
import com.fostcraiv2.appDemo.service.ServicioService;

@Controller
public class ServicioControlador {

	@Autowired
	private ServicioService service;
	
	@GetMapping({ "/servicios", "/" })
	public String listarServicios(Model modelo) {
		modelo.addAttribute("servicios", service.listarServicios());
		return "servicios";
	}
	
	@GetMapping("/servicios/nuevo")
	public String formularioServicio(Model modelo) {
		Servicio servicio = new Servicio();
		modelo.addAttribute("servicio", servicio);
		return "crear_servicio";
	}
	
	@PostMapping("/servicios")
	public String guardarServicio(@ModelAttribute("servicio") Servicio servicio) {
		service.guardarServicio(servicio);
		return "redirect:servicios";
	}
	
	@GetMapping("/servicios/editar/{id}")
	public String formularioEditarServicio(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("servicio", service.obtenerServicioporId(id));
		return "editar_servicio";
	}
	
	@PostMapping("/servicios/{id}")
	public String actualizarServicios(@PathVariable Long id, @ModelAttribute("servicio") Servicio servicio, Model modelo) {
		Servicio servicioExistente = service.obtenerServicioporId(id);
		servicioExistente.setId(id);
		servicioExistente.setNombre_servicio(servicio.getNombre_servicio());
		servicioExistente.setValor(servicio.getValor());
		
		service.actualizarServicio(servicioExistente);
		return "redirect:servicios";
	}
	
	@GetMapping("/servicios/{id}")
	public String eliminarServicio(@PathVariable Long id) {
		service.eliminarServicio(id);
		return "redirect:servicios";
	}
	
}
