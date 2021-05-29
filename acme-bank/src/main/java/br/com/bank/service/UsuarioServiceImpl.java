package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.UsuarioDaoImpl;
import br.com.bank.model.Usuario;

public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioDaoImpl dao;
	
	public UsuarioServiceImpl() {
		this.dao = new UsuarioDaoImpl();
	}

	@Override
	public List<Usuario> list() {
		return this.dao.list();
	}

	@Override
	public void save(Usuario usuario) {
		this.dao.save(usuario);
	}

	@Override
	public void deleteById(Long idUsuario) {
		this.dao.deleteById(idUsuario);
	}

	@Override
	public void edit(Usuario usuario) {
		this.dao.edit(usuario);
		
	}

	@Override
	public Usuario getById(Long id) {
		return this.getById(id);
	}

}
