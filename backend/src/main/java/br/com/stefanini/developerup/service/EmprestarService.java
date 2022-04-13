package br.com.stefanini.developerup.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.developerup.dao.AutorDao;
import br.com.stefanini.developerup.dao.ClienteDao;
import br.com.stefanini.developerup.dao.EmprestarDao;
import br.com.stefanini.developerup.dao.LivroDao;
import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.EmprestarDto;
import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.model.Emprestar;
import br.com.stefanini.developerup.model.Livro;
import br.com.stefanini.developerup.parser.AutorParser;
import br.com.stefanini.developerup.parser.EmprestarParser;

@RequestScoped
public class EmprestarService {

	
	@Inject
	EmprestarDao daoEmprestar;
	
	@Inject
	ClienteDao daoCliente;
	
	@Inject
	LivroDao daoLivro;
	
	
	public List<EmprestarDto> listar() {
		return daoEmprestar.listar().stream().map(EmprestarParser.get()::dtoObj).collect(Collectors.toList());
	}
	
	public Emprestar inserir(EmprestarDto dto) {
		try {
			
			Livro objLivro = daoLivro.pesquisarLivro(dto.getIdLivro());
			Cliente objCliente = daoCliente.pesquisarCliente(dto.getIdCliente());
			
			
			
			if(objLivro.getId() != null && objCliente.getId() != null) {
				/*if(validarEmprestimo(objLivro, objCliente)) {
					Emprestar emprestimo = new Emprestar(objCliente, objLivro, dto.getDataInicio(), dto.getDataEntrega(), dto.getStatus());
					daoEmprestar.inserir(emprestimo);
					return emprestimo;	
				}*/
				Emprestar emprestimo = new Emprestar(objCliente, objLivro, dto.getDataInicio(), dto.getDataEntrega(), dto.getStatus());
				daoEmprestar.inserir(emprestimo);
				return emprestimo;	
				
				
				
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
		
	}
	
	public List<Emprestar> validarEmprestimo() {
		//ESTOQUE DO LIVRO.
		//Optional<Emprestar> emprestados = daoEmprestar.emprestimos(livro.getId());
		List<Emprestar> emprestados = daoEmprestar.emprestimos(1);
		return emprestados;
		
		/*int quantidadeEmprestimo = livro.getQuantidade();
		if(quantidadeEmprestimo < livro.getQuantidade()) {
			return true;
		}*/
		
		
		//return null;
	}
}
