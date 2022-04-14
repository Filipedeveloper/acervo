package br.com.stefanini.developerup.parser;

import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.dto.EmprestarDto;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.model.Emprestar;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
public class EmprestarParser {
    public static EmprestarParser get(){
        return  new EmprestarParser();
    }

    public EmprestarDto dto(Emprestar entidade){
    	EmprestarDto dto = new EmprestarDto();

        dto.setIdCliente(entidade.getCliente().getId());
        dto.setIdLivro(entidade.getLivro().getId());
        dto.setDataInicio(entidade.getDataInicio());
        dto.setDataEntrega(entidade.getDataEntrega());
        dto.setStatus(entidade.getStatus());
        
        return dto;
    }
    
    public EmprestarDto dtoObj(Emprestar entidade){
    	EmprestarDto dto = new EmprestarDto();

        dto.setCliente(entidade.getCliente());
        dto.setLivro(entidade.getLivro());
        dto.setDataInicio(entidade.getDataInicio());
        dto.setDataEntrega(entidade.getDataEntrega());
        dto.setStatus(entidade.getStatus());
        
        return dto;
    }
}
