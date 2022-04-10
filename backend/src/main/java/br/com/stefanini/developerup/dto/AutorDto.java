package br.com.stefanini.developerup.dto;

import java.io.Serializable;

import br.com.stefanini.developerup.model.Autor;

public class AutorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;
	private String isni;
	private String email;
	private String dataNascimento;
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

}
