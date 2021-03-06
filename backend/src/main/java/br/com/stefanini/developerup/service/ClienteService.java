package br.com.stefanini.developerup.service;



import br.com.stefanini.developerup.dao.ClienteDao;
import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.parser.ClienteParser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
@RequestScoped
public class ClienteService {
    @Inject
    ClienteDao dao;

    public List<ClienteDto> listar(){
        return dao.listar().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());
    }
    
    public void inserir(Cliente cliente) {
		dao.inserir(cliente);
	}
    
    public void deletar(Integer id) {
		dao.deletar(id);
	}
    
    public Cliente atualizar(Integer id, Cliente cliente) {
		//VALIDAR ID DO Cliente
		try {
			Cliente obj = dao.pesquisarCliente(id);
			if(obj.getId() != null) {
				dao.atualizar(id, cliente);
				return cliente;
			}
		} catch (Exception e) {
			return null;
		}
		 
		return null;
		
		//dao.atualizar(autor);
	}
}
