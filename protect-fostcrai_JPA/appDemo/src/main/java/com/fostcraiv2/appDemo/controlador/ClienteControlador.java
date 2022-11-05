package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Cliente;
import com.fostcraiv2.appDemo.service.ClienteService;

@Controller
public class ClienteControlador {

	@Autowired
	private ClienteService servicio;
	
	@GetMapping({"/clintes", "/"})
	public String listarClientes(Model modelo){
		modelo.addAttribute("clientes", servicio.listarTodosLosClientes());
		return "clientes";
	}
	
	@GetMapping("Clietnes/nuevo")
	public String formularioNuevoCliente(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("cliente", cliente);
		return "crear_cliente";
	}
	
	@PostMapping("/clientes")
	public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
		servicio.guardarCliente(cliente);
		return "redirect:cllientes";
	}
	
	@GetMapping("Clietnes/editar/{id}")
	public String formularioEditarCliente(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("cliente", servicio.obtenerClienteporId(id));
		return "editar_cliente";
	}
	
	@PostMapping("/clientes/{id}")
	public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente, Model modelo) {
		Cliente clienteExistente = servicio.obtenerClienteporId(id);
		clienteExistente.setId(id);
		clienteExistente.setNombre(cliente.getNombre());
		clienteExistente.setApellido(cliente.getApellido());
		clienteExistente.setCedula(cliente.getCedula());
		clienteExistente.setCelular(cliente.getCelular());
		clienteExistente.setCorreo(cliente.getCorreo());
		clienteExistente.setDireccion(cliente.getDireccion());
		clienteExistente.setFecha_del_evento(cliente.getFecha_del_evento());
		
		servicio.actualizarCliente(clienteExistente);
		return "redirect:cllientes";
	}
	
	@GetMapping("/clientes/{id}")
	public String eliminarCliente(@PathVariable Long id) {
		servicio.eiminarCliente(id);
		return "redirect:cllientes";
	}
}
