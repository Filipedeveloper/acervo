package br.com.stefanini.developerup.parser;

import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Cliente;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
public class ClienteParser {
    public static ClienteParser get(){
        return  new ClienteParser();
    }

    public ClienteDto dto(Cliente entidade){
        ClienteDto dto = new ClienteDto();

        dto.setEmail(entidade.getEmail());
        dto.setNome(entidade.getNome());
        dto.setContato(entidade.getContato());
        dto.setEmprestimos(entidade.getEmprestimos());

        return dto;
    }
    
    public Cliente fromCliente(ClienteDto dto) {
    	Cliente cliente = new Cliente();
    	cliente.setNome(dto.getNome());
    	cliente.setEmail(dto.getEmail());
    	cliente.setContato(dto.getContato());
    	return cliente;
    }
}
