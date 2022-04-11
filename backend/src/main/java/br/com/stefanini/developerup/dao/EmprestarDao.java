package br.com.stefanini.developerup.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Emprestar;

@RequestScoped
public class EmprestarDao {

	public List<Emprestar>listar(){
		return Emprestar.listAll();
	}
	
	@Transactional
	public void inserir(Emprestar emprestar) {
		Emprestar.persist(emprestar);
	}
}
