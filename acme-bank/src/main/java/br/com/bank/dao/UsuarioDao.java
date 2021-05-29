package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Usuario;

public interface UsuarioDao {
	
	
	public List<Usuario> list();
	
	public void save(Usuario usuario);
	
	public void deleteById(Long idUsuario);
	
	public void edit(Usuario usuario);
	
	public Usuario getById(Long id);
}
