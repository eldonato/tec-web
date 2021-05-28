package br.com.bank.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bank.model.Usuario;
import br.com.bank.util.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Usuario c");
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}

	@Override
	public void save(Usuario usuario) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		try {

			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void deleteById(Long idUsuario) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		
		try {
			
			Usuario usuario = entityManager.find(Usuario.class, idUsuario);
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public void edit(Usuario usuario) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		try {
			entityManager.merge(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
