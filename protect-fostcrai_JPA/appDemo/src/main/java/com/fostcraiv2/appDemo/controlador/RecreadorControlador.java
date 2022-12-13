package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Recreador;
import com.fostcraiv2.appDemo.service.RecreadorService;

@Controller
public class RecreadorControlador {

	@Autowired
	private RecreadorService service;
	
	@GetMapping({"/recreadores","/"})
	public String listarRecreadores(Model modelo) {
		modelo.addAttribute("recreadores", service.listarRecreadores());
		return "recreadores";
	}
	
	@GetMapping("/recreadores/nuevo")
	public String formularioRecreador(Model modelo) {
		Recreador recreador = new Recreador();
		modelo.addAttribute("recreador", recreador);
		return "recreador_nuevo";
	}
	
	@PostMapping("/recreadores")
	public String guardarRecreador(@ModelAttribute("recreador") Recreador recreador) {
		service.guardarRecreador(recreador);
		return "redirect:recreadores";
	}
	
	
	@GetMapping("/recreadores/editar/{id}")
	public String formularioEditarRecreador(@PathVariable Long id, Model modelo){
		modelo.addAttribute("recreador", service.obtenerRecreadorporId(id));
		return "editar_recrerador";
	}
	
	@PostMapping("/recreadores/{id}")
	public String actualizarRecreador(@PathVariable Long id,@ModelAttribute("recreador") Recreador recreador, Model modelo) {
		Recreador recreadorExistente = service.obtenerRecreadorporId(id);
		
		recreadorExistente.setId(id);
		recreadorExistente.setEdad(recreador.getEdad());
		recreadorExistente.setFecha_nacimiento(recreador.getFecha_nacimiento());
		recreadorExistente.setId_capacitacion_fk(recreador.getId_capacitacion_fk());
		recreadorExistente.setId_usuario_fk(recreador.getId_usuario_fk());
		
		service.actualizarRecreador(recreadorExistente);
		return "redirect:recreadores";
	}
	
	@GetMapping("/recreadores/{id}")
	public String eliminarRecreador(@PathVariable Long id) {
		service.eliminarRecreador(id);
		return "redirect:recreadores";
	}
	
}
