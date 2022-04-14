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
import io.quarkus.logging.Log;

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
			
			if(validarEmprestimo(objLivro, objCliente)) {
				Emprestar emprestimo = new Emprestar(objCliente, objLivro, dto.getDataInicio(), dto.getDataEntrega(), dto.getStatus());
				daoEmprestar.inserir(emprestimo);
				return emprestimo;	
			}
			return null;
			
		} catch (Exception e) {
			return null;
		}
		
		
		
	}
	
	public Boolean validarEmprestimo(Livro objLivro, Cliente objCliente) {
		int quantidadePermitida = 3;
		Boolean validar = true;
		
		
		//VALIDA INFORMAÇÕES DE LIVRO E CLIENTE
		if(objLivro.getId() != null && objCliente.getId() != null) {
			List<Emprestar> emprestados = daoEmprestar.emprestimosPorLivroDisponivel(objLivro.getId());
				
			//VERIFICO SE TEM LIVRO DISPONIVEL
			if(emprestados.size() < objLivro.getQuantidade()) {
				List<Emprestar> livrosCliente = daoEmprestar.emprestimosPorCliente(objCliente.getId(), objLivro.getId());
				
				Log.info("IDLivro: DEU CERTO!!!!!" + livrosCliente.size());
				//VERIFICA SE O CLIENTE NÃO ALCANÇOU O LIMITE DE EMPRESTIMOS
				if(emprestados.size() < quantidadePermitida) {
					validar = true;
				}else {
					validar = false;
				}
			}
		}
		
		//return validar;
		return validar;
		
	}
	
	
	public List<Emprestar> listarEmprestimo() {
		int quantidadePermitida = 3;
		Boolean validar = true;
		Livro objLivro = daoLivro.pesquisarLivro(1);
		Cliente objCliente = daoCliente.pesquisarCliente(1);
		
		
		//VALIDA INFORMAÇÕES DE LIVRO E CLIENTE
		if(objLivro.getId() != null && objCliente.getId() != null) {
			List<Emprestar> emprestados = daoEmprestar.emprestimosPorLivroDisponivel(objLivro.getId());
			List<Emprestar> livrosCliente = daoEmprestar.emprestimosPorCliente(objCliente.getId(), objLivro.getId());
			Log.info("IDLivro: NÃO DEU CERTO " + livrosCliente.size() );
			return emprestados;
		}
		
		return null;
		
	}
	
	public List<Emprestar> listarrEmprestimo() {
		int quantidadePermitida = 3;
		Boolean validar = true;
		Livro objLivro = daoLivro.pesquisarLivro(1);
		Cliente objCliente = daoCliente.pesquisarCliente(1);
		
		
		//VALIDA INFORMAÇÕES DE LIVRO E CLIENTE
		if(objLivro.getId() != null && objCliente.getId() != null) {
			List<Emprestar> emprestados = daoEmprestar.emprestimosPorLivroDisponivel(objLivro.getId());
				
			//VERIFICO SE TEM LIVRO DISPONIVEL
			if(emprestados.size() < objLivro.getQuantidade()) {
				List<Emprestar> livrosCliente = daoEmprestar.emprestimosPorCliente(objCliente.getId(), objLivro.getId());
				
				//VERIFICA SE O CLIENTE NÃO ALCANÇOU O LIMITE DE EMPRESTIMOS
				if(livrosCliente.size() < quantidadePermitida) {
					if(livrosCliente.isEmpty()) {
						Log.info("IDLivro: DEU CERTO!!!!!" );
						return livrosCliente;
					}else {
						//PERCORRE OS LIVROS E VERIFICA SE JA POSSUI O LIVRO EM QUESTÃO
						/*Log.info("IDLivro: NÃO DEU CERTO" );
						for(Emprestar e : livrosCliente) {
							
							
							if(e.getLivro().getId().equals(objLivro.getId())) {
								
								return livrosCliente;
							}
						}*/
					}
				}
			}
		}
		
		return null;
		
	}
}
