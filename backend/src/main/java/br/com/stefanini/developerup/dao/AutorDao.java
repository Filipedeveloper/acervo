package br.com.stefanini.developerup.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.developerup.model.Autor;

@RequestScoped
public class AutorDao {
	
	public List<Autor>listar(){
		return Autor.listAll();
	}
	
	public Autor pesquisarAutor(Integer id){
		//return Autor.findById(id);
		return Autor.findById(id);
	}
	
	@Transactional
	public Autor inserir(Autor autor) {
		Autor.persist(autor);
		return autor;
	}
	
	@Transactional
	public void deletar(Integer id) {
		Autor.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Integer id, Autor autor) {
		Autor obj =  Autor.findById(id);
		obj.setNome(autor.getNome());
		obj.setIsni(autor.getIsni());
		obj.setEmail(autor.getEmail());
		obj.setDataNascimento(autor.getDataNascimento());
		obj.setBiografia(autor.getBiografia());
	}

}
