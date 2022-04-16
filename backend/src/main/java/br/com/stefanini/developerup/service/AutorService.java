package br.com.stefanini.developerup.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.stefanini.developerup.dao.AutorDao;
import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.parser.AutorParser;
import br.com.stefanini.developerup.parser.ClienteParser;
import io.quarkus.logging.Log;

@RequestScoped
public class AutorService {

	@Inject
	AutorDao dao;
	
	public List<AutorDto> listar() {
		return dao.listar().stream().map(AutorParser.get()::dto).collect(Collectors.toList());
	}
	
	
	public AutorDto inserir(AutorDto autor) throws ParseException {
		if(validarEmail(autor.getEmail())) {

			//Log.info("ESTOU AQUIIIIII " + autor.getDataNascimento());

    		return AutorParser.get().dto(dao.inserir(AutorParser.get().fromAutor(autor)));
    	}
    	return null;
		
	}
	public void deletar(Integer id) {
		dao.deletar(id);
	}
	
	public Autor atualizar(Integer id, Autor autor) {
		//VALIDAR ID DO AUTOR
		try {
			Autor obj = dao.pesquisarAutor(id);
			if(obj.getId() != null) {
				dao.atualizar(id, autor);
				return autor;
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
