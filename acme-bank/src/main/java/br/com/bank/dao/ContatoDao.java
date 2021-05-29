package br.com.bank.dao;

import java.util.List;

import br.com.bank.model.Contato;

public interface ContatoDao {

	void salvar(Contato contato);
	
	List<Contato> list();
	
	void editar(Contato contato);
	
	void remover(Long id);
	
	Contato getContatoById(Long id);
}
