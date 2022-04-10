package br.com.stefanini.developerup.parser;

import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
public class AutorParser {
    public static AutorParser get(){
        return  new AutorParser();
    }

    public AutorDto dto(Autor autor){
        AutorDto dto = new AutorDto();        
        
		dto.setNome(autor.getNome());
		dto.setIsni(autor.getIsni());
		dto.setEmail(autor.getEmail());
		dto.setDataNascimento(autor.getDataNascimento());
		dto.setBiografia(autor.getBiografia());
        return dto;
    }
}
