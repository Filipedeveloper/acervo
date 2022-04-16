package br.com.stefanini.developerup.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LivroDto {
	
	private Integer id;
	
	@NotBlank
	@Length(max = 50)
	private String nome;
	private Integer autorId;
	
	
	private String anoPublicacao;
	
	@NotBlank
	@Length(max = 50)
	private String editora;	
	private String isbn;
	
	@NotBlank
	@Length(min = 1)
	private Integer quantidade;
	
	
	
	public LivroDto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getAutorId() {
		return autorId;
	}
	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
