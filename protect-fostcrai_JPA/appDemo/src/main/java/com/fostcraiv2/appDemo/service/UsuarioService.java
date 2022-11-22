package com.fostcraiv2.appDemo.service;

import java.util.List;

import com.fostcraiv2.appDemo.Genericos.GenericServiceAPI;
import com.fostcraiv2.appDemo.entidad.Usuario;

public interface UsuarioService extends GenericServiceAPI<Usuario, Long>{

	public List<Usuario> listarTodosLosUsuarios();
	
	public Usuario guardarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuarioPorId(Long id);
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
	
	
}
