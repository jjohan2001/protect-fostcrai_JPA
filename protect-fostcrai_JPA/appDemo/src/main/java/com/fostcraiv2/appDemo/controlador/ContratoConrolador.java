package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Contrato;
import com.fostcraiv2.appDemo.service.ContratoService;

@Controller
public class ContratoConrolador {

	@Autowired
	private ContratoService service;
	
	@GetMapping({"/contratos", "/"})
	public String listarContratos(Model modelo) {
		modelo.addAttribute("contratos", service.listarContratos());
		return "contratos";
	}
	
	@GetMapping("/contratos/nuevo")
	public String formularioContrato(Model modelo) {
		Contrato contrato = new Contrato();
		modelo.addAttribute("contrato", contrato);
		return "contrato_nuevo";
	}
	
	@PostMapping("/contratos")
	public String guardarContrato(@ModelAttribute("contrato") Contrato contrato) {
		service.guardarContrato(contrato);
		return "redirect:contratos";
	}
	
	@GetMapping("/contratos/editar/{id}")
	public String formularioEditarContrato(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("contrato", service.obtenerContratoporId(id));
		return "editar_contrato";
	}
	
	@PostMapping("/contratos/{id}")
	public String actualizarContrato(@PathVariable Long id, @ModelAttribute("contrato") Contrato contrato, Model modelo) {
		Contrato contratoExistente = service.obtenerContratoporId(id);
		contratoExistente.setId(id);
		contratoExistente.setFecha_entrada(contrato.getFecha_entrada());
		contratoExistente.setDias(contrato.getDias());
		contratoExistente.setHoras(contrato.getHoras());
		
		return "redirect:contratos";
	}
	
	@GetMapping("contratos/{id}")
	public String eliminarContrato(@PathVariable Long id) {
		service.eliminarContrato(id);
		return "redirect:contratos";
	}
	
}
