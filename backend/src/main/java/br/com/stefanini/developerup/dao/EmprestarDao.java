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
	
	public List<Emprestar>emprestimos(Integer idLivro){
		//TypedQuery<Emprestar> query = em.createQuery("SELECT staus FROM Emprestar emprestar	where livro.id = :id", Emprestar.class);
		//query.setParameter("id", "1");
		//Emprestar.find("idlivro", idLivro).
		List<Emprestar> emp = em.createNativeQuery("SELECT livro_id, cliente_id FROM emprestar where livro_id = :livro_id AND status = :status")
		.setParameter("livro_id", 1)
		.setParameter("status", "Emprestado")
		.getResultList();
		
		int quantidadeEmprestimo = emp.size();
		//CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
		//Root<Emprestar> root = criteria.from( Emprestar.class );
		//Path<Long> idPath = root.get(Emprestar.);
		//
		//query.setParameter("status", "emprestado");
		return emp;
	}
	
	
	
	
}
