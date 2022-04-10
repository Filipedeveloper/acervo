package br.com.stefanini.developerup.parser;

import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.model.Livro;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
public class LivroParser {
    public static LivroParser get(){
        return  new LivroParser();
    }

    public LivroDto dto(Livro livro){
    	LivroDto dto = new LivroDto();        
        
		dto.setNome(livro.getNome());
		dto.setIsbn(livro.getIsbn());
		dto.setEditora(livro.getEditora());
		dto.setAnoPublicacao(livro.getAnoPublicacao());
		dto.setAutorId(livro.getAutor().getId());
		
        return dto;
    }
}
