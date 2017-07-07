package com.solmit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solmit.entidad.Usuario;
import com.solmit.repository.UsuarioRepository;
import com.solmit.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository dao;

	@Override
	public Usuario obtenerUsuario(String idUsuario) throws Exception {
		return dao.obtenerUsuario(idUsuario);
	}

	@Override
	public List<Usuario> listarUsuarios() throws Exception {
		System.out.println("aca");
		return dao.listarUsuarios();
	}

	@Override
	public void eliminar(Usuario usuario) throws Exception {
		dao.eliminar(usuario);

	}

	@Override
	public void persistir(Usuario usuario) throws Exception {
		dao.persistir(usuario);
	}

	@Override
	public void actualizar(Usuario usuario) throws Exception {
		dao.actualizar(usuario);
	}

}
