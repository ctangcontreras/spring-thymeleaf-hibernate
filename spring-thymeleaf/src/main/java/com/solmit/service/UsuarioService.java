package com.solmit.service;
import java.util.List;

import com.solmit.entidad.Usuario;

public interface UsuarioService {

	

	public Usuario obtenerUsuario(String idUsuario)throws Exception;

	public   List<Usuario> listarUsuarios() throws Exception;

	public void eliminar(Usuario usuario) throws Exception;

	public void persistir(Usuario usuario) throws Exception;

	public void actualizar(Usuario usuario) throws Exception;
	
}
