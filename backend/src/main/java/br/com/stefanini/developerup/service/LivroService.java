package br.com.stefanini.developerup.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.developerup.dao.AutorDao;
import br.com.stefanini.developerup.dao.LivroDao;
import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Livro;
import br.com.stefanini.developerup.parser.AutorParser;
import br.com.stefanini.developerup.parser.LivroParser;
import io.quarkus.logging.Log;

@RequestScoped
public class LivroService {

	@Inject
	LivroDao dao;
	
	@Inject
	AutorDao daoAutor;
	
	public List<Livro> listar() {
		return dao.listar();
	}
	
	public void deletar(Integer id) {
		dao.deletar(id);
	}
	
	public Livro inserir(LivroDto dto) {
		
		
		
		try {
			Autor obj = daoAutor.pesquisarAutor(dto.getAutorId());
			if(obj.getId() != null) {
				Livro livro = new Livro(null, dto.getNome(), dto.getAnoPublicacao(), dto.getEditora(), dto.getIsbn(), dto.getQuantidade(), obj);
				dao.inserir(livro);
				return livro;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		return null;
		/*try {
			Autor obj = daoAutor.pesquisarAutor(dto.getAutorId());
			if(obj.getId() != null) {
				Livro livro = new Livro(null, dto.getNome(), dto.getAnoPublicacao(), dto.getEditora(), dto.getIsbn(), dto.getQuantidade(), obj);
				dao.inserir(livro);
				return livro;
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;*/
		
	}
	
	public Livro atualizar(Integer id, LivroDto dto) {
		try {
			Autor obj = daoAutor.pesquisarAutor(dto.getAutorId());
			Livro livroAtual = dao.pesquisarLivro(id);
			
			if(obj.getId() != null && livroAtual.getId() != null) {
				Livro novoLivro = new Livro(null, dto.getNome(), dto.getAnoPublicacao(), dto.getEditora(), dto.getIsbn(), dto.getQuantidade(), obj);
				dao.atualizar(id, novoLivro);
				return novoLivro;
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
		
	}
}
