package com.fostcraiv2.appDemo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fostcraiv2.appDemo.entidad.Usuario;
import com.fostcraiv2.appDemo.service.UsuarioService;

@Controller
public class UsuarioControlador {

	@Autowired
	private UsuarioService service;

	@GetMapping({ "/usuarios", "/" })
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", service.listarTodosLosUsuarios());
		return "usuarios";
	}

	@GetMapping("/usuarios/nuevo")
	public String mostrarFormularioDeRegistrarUsuarios(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "crear_usuario";
	}

	@PostMapping("/usuarios")
	public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		service.guardarUsuario(usuario);
		return "redirect:usuarios";
	}

	@GetMapping("/usuarios/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", service.obtenerUsuarioPorId(id));
		return "editar_usuario";
	}

	@PostMapping("/usuarios/{id}")
	public String actualizarUsuarios(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario usuarioExistente = service.obtenerUsuarioPorId(id);
		usuarioExistente.setId(id);
		usuarioExistente.setNombre(usuario.getNombre());
		usuarioExistente.setApellido(usuario.getApellido());
		usuarioExistente.setCedula(usuario.getCedula());
		usuarioExistente.setCelular(usuario.getCelular());
		usuarioExistente.setDireccion(usuario.getDireccion());
		usuarioExistente.setCorreo(usuario.getCorreo());
		usuarioExistente.setPassword(usuario.getPassword());
		usuarioExistente.setRol(usuario.getRol());

		service.actualizarUsuario(usuarioExistente);
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
		service.eliminarUsuario(id);
		return "redirect:/usuarios";
	}

}
