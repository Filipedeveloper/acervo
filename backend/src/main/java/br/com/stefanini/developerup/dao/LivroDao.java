package br.com.stefanini.developerup.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Livro;

@RequestScoped
public class LivroDao {

	
	public List<Livro>listar(){
		return Livro.listAll();
	}
	
	public Livro pesquisarLivro(Integer id){
		
		return Livro.findById(id);
	}
	
	
	@Transactional
	public void inserir(Livro livro) {
		Autor.persist(livro);
	}
	
	@Transactional
	public void deletar(Integer id) {
		Livro.deleteById(id);
	}
	
	@Transactional
	public void atualizar(Integer id, Livro livro) {
		Livro obj =  Livro.findById(id);
		obj.setNome(livro.getNome());
		obj.setAnoPublicacao(livro.getAnoPublicacao());
		obj.setEditora(livro.getEditora());
		obj.setIsbn(livro.getIsbn());
		obj.setQuantidade(livro.getQuantidade());
		obj.setAutor(livro.getAutor());
	}
}
