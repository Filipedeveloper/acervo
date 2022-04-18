package br.com.stefanini.developerup.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	SimpleDateFormat sds = new SimpleDateFormat("dd/MM/yyyy");
    public static AutorParser get(){
        return  new AutorParser();
    }

    public AutorDto dto(Autor autor){
    	
        AutorDto dto = new AutorDto();        
        
        dto.setId(autor.getId());
		dto.setNome(autor.getNome());
		dto.setIsni(autor.getIsni());
		dto.setEmail(autor.getEmail());
		//dto.setDataNascimento(sds.format(autor.getDataNascimento()));
		dto.setDataNascimento(autor.getDataNascimento());
		dto.setBiografia(autor.getBiografia());
        return dto;
    }
    
    public Autor fromAutor(AutorDto dto) {
    	Autor autor = new Autor();
    	autor.setId(dto.getId());
    	autor.setNome(dto.getNome());
    	autor.setIsni(dto.getIsni());
    	autor.setEmail(dto.getEmail());
		//autor.setDataNascimento(sds.parse(dto.getDataNascimento()));
    	autor.setDataNascimento(dto.getDataNascimento());
		autor.setBiografia(dto.getBiografia());
    	
    	return autor;
    }
}
