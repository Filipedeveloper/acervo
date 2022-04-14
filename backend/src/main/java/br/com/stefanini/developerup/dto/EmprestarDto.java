package br.com.stefanini.developerup.dto;

import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.model.Livro;

public class EmprestarDto {
	
	private String dataInicio;
	private String dataEntrega;
	private String status;
	
	private Integer idCliente;
	private Integer idLivro;
	
	private Cliente cliente;
	private Livro livro;
	
	
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	

}
