package br.com.stefanini.developerup.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.stefanini.developerup.model.Emprestar;

/**
 * @author Danilo Dorgam
 * email danilodorgam@gmail.com
 * created 30/03/2022
 * @version 0.1.0
 */
public class ClienteDto {

	@NotBlank(message = "Preenchimento obrigatorio")
    private String email;

	@NotBlank(message = "Preenchimento obrigatorio")
	@Length(max = 50, message = "Deve possuir no máximo 50 caracteres")
    private String nome;

	
	@NotBlank(message = "Preenchimento obrigatorio")
    private String contato;
    
    private Set<Emprestar> emprestimos = new HashSet<>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

	public Set<Emprestar> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(Set<Emprestar> emprestimos) {
		this.emprestimos = emprestimos;
	}
}