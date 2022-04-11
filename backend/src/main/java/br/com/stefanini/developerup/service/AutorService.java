package br.com.stefanini.developerup.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.stefanini.developerup.dao.AutorDao;
import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.parser.AutorParser;
import br.com.stefanini.developerup.parser.ClienteParser;

@RequestScoped
public class AutorService {

	@Inject
	AutorDao dao;
	
	public List<AutorDto> listar() {
		return dao.listar().stream().map(AutorParser.get()::dto).collect(Collectors.toList());
	}
	
	public void inserir(Autor autor) {
		dao.inserir(autor);
	}
	public void deletar(Integer id) {
		dao.deletar(id);
	}
	
	public Autor atualizar(Integer id, Autor autor) {
		//VALIDAR ID DO AUTOR
		try {
			Autor obj = dao.pesquisarAutor(id);
			if(obj.getId() != null) {
				dao.atualizar(id, autor);
				return autor;
			}
		} catch (Exception e) {
			return null;
		}
		 
		return null;
		
		//dao.atualizar(autor);
	}
}
