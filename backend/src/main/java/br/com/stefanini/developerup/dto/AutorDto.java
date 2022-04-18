package br.com.stefanini.developerup.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.stefanini.developerup.model.Autor;

public class AutorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotBlank(message = "Preenchimento obrigatorio")
	@Length(max = 50, message = "Deve possuir no máximo 50 caracteres")
	private String nome;
	private String isni;
	
	@NotBlank(message = "Preenchimento obrigatorio")
	private String email;
	
	@Past
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	@Length(max = 200, message = "Deve possuir no máximo 200 caracteres")
	private String biografia;
	
	
	
	

	
	
	public AutorDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIsni() {
		return isni;
	}
	public void setIsni(String isni) {
		this.isni = isni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

}
