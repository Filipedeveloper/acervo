package br.com.stefanini.developerup.dao;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Emprestar;

@RequestScoped
public class EmprestarDao {
	
	@PersistenceContext
    EntityManager em;

	public List<Emprestar>listar(){
		return Emprestar.listAll();
	}
	
	@Transactional
	public void inserir(Emprestar emprestar) {
		Emprestar.persist(emprestar);
	}
	
	@SuppressWarnings("unused")
	public List<Emprestar>emprestimosPorLivroDisponivel(Integer idLivro){
		
		@SuppressWarnings("unchecked")
		List<Emprestar> emp = em.createNativeQuery("SELECT livro_id, cliente_id,status FROM emprestar where livro_id = :livro_id AND status = :status")
		.setParameter("livro_id", idLivro)
		.setParameter("status", true)
		.getResultList();
		
		return emp;
	}
	
	@SuppressWarnings("unused")
	public List<Emprestar>emprestimosPorCliente(Integer idCliente, Integer idLivro){
		
		@SuppressWarnings("unchecked")
		List<Emprestar> emp = em.createNativeQuery("SELECT livro_id, cliente_id,status FROM emprestar where livro_id = :livro_id AND cliente_id = :cliente_id AND status = :status")
		.setParameter("livro_id", idLivro)
		.setParameter("cliente_id", idCliente)
		.setParameter("status", true)
		.getResultList();
		
		return emp;
	}
	
	
	
	
}
