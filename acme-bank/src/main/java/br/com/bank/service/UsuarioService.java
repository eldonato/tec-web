package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Usuario;


public interface UsuarioService {
	
	
	public List<Usuario> list();
	
	public void save(Usuario usuario);
	
	public void deleteById(Long idUsuario);
	
	public void edit(Usuario usuario);
	
	public Usuario getById(Long id);
}
