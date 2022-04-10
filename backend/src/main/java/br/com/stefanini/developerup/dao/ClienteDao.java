package br.com.stefanini.developerup.dao;

import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import java.util.List;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
@RequestScoped
public class ClienteDao {
    public List<Cliente> listar(){
        return Cliente.listAll(Sort.by("nome,email,contato").ascending());
    }
    
    public Cliente pesquisarCliente(Integer id){
		//return Autor.findById(id);
		return Cliente.findById(id);
	}
    
    @Transactional
	public void inserir(Cliente cliente) {
		Autor.persist(cliente);
	}
    
    @Transactional
	public void deletar(Integer id) {
		Cliente.deleteById(id);
	}
    
    @Transactional
	public void atualizar(Integer id, Cliente cliente) {
		Cliente obj =  Cliente.findById(id);
		obj.setNome(cliente.getNome());
		obj.setEmail(cliente.getEmail());
		obj.setContato(cliente.getContato());
	}

}
