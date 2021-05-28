/**
 * 
 */
package br.com.bank.service;

import java.util.List;

import br.com.bank.model.Contato;

 
public interface ContatoService {
	
	void salvar(Contato contato);
	
	List<Contato> list();

}
