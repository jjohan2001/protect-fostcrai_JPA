package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.SolicitudServicio;
import com.fostcraiv2.appDemo.service.SolicitudServicioService;

@Controller
public class SolcitudServicioControlador {

	@Autowired
	private SolicitudServicioService service;
	
	@GetMapping({"/solicitudes", "/"})
	public String listarSolicitudes(Model modelo) {
		modelo.addAttribute("servicios", service.listarSolicitudes());
		return "solicitudes";
	}
	
	@GetMapping("/solicitudes/nueva")
	public String formularioSolicitud(Model modelo) {
		SolicitudServicio solicitud = new SolicitudServicio(null, null, null, null, null);
		modelo.addAttribute("solicitud", solicitud);
		return "crear_solicitud";
	}
	
	@PostMapping("/solicitudes")
	public String guardarSolicitud(@ModelAttribute("solicitud") SolicitudServicio solicitud) {
		service.guardarSolictudes(solicitud);
		return "redirect:solicitudes";
	}
	
	@GetMapping("/solicitudes/editar/{id}")
	public String formularioEditarSolicitud(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("solicitud", service.obtenerSolicitudpoId(id));
		return "editar_solicitud";
	}
	
	@PostMapping("/solicitudes/{id}")
	public String actualizarSolicitud(@PathVariable Long id, @ModelAttribute("solicitud") SolicitudServicio solicitud, Model modelo){
		SolicitudServicio solicitudExistente = service.obtenerSolicitudpoId(id);
		solicitudExistente.setId(id);
		solicitudExistente.setFecha_servicio(solicitud.getFecha_servicio());
		solicitudExistente.setId_cliente_fk(solicitud.getId_cliente_fk());
		solicitudExistente.setId_servicio_fk(solicitud.getId_servicio_fk());
		
		service.actualiizarSolicitud(solicitudExistente);
		return "redirect:solicitudes";	
	}
	
	@GetMapping("/solicitudes/{id}")
	public String eliminarSolicitud(@PathVariable Long id) {
		service.eliminarsolicitud(id);
		return "redirect:solicitudes";
	}
}
