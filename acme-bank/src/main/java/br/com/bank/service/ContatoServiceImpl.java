/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.dao.ContatoDaoImpl;
import br.com.bank.model.Contato;

/**
 * @author cbgomes
 *
 */
public class ContatoServiceImpl implements ContatoService {
	
	private ContatoDaoImpl dao;
	
	public ContatoServiceImpl() {
		this.dao = new ContatoDaoImpl();
	}

	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public List<Contato> list() {
		return this.dao.list();
	}

	@Override
	public void editar(Contato contato) {
		this.dao.editar(contato);
		
	}

	@Override
	public void remover(Long id) {
		this.dao.remover(id);		
	}

	@Override
	public Contato getContatoById(Long id) {
		return this.dao.getContatoById(id);
	}	
}
