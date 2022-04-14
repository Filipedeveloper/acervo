package br.com.stefanini.developerup.service;



import br.com.stefanini.developerup.dao.ClienteDao;
import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.parser.ClienteParser;
import io.quarkus.logging.Log;

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
    
    public ClienteDto inserir(ClienteDto dto) {
    	
    	if(validarEmail(dto.getEmail())) {
    		dao.inserir(ClienteParser.get().fromCliente(dto));
    		return dto;
    	}
    	return null;
    	
		
	}
    
    public void deletar(Integer id) {
		dao.deletar(id);
	}
    
    public ClienteDto atualizar(Integer id, ClienteDto cliente) {
		//VALIDAR ID DO Cliente
		try {
			Cliente obj = dao.pesquisarCliente(id);
			if(obj.getId() != null) {
				dao.atualizar(id, ClienteParser.get().fromCliente(cliente));
				return cliente;
			}
		} catch (Exception e) {
			return null;
		}
		 
		return null;
		
		//dao.atualizar(autor);
	}
    
    public Boolean validarEmail(String email) {
    	Boolean validar = false;
    	if(email.contains(".")) {
            int totalCaracteres = 0;
            char temp;
            Log.info("IDLivro: DEU CERTO!!!!!" + email.length());
            for (int i = 0; i < email.length(); i++) {
            	
                temp = email.charAt(i);
                if (temp == '@') {
                	totalCaracteres++;
                }
            }
            if(totalCaracteres == 1) {
            	validar = true;
            }else {
            	validar = false;
            }
            
    	}
    	return validar;
    }
}
