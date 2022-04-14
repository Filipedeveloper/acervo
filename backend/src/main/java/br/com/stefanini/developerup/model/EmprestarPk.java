package br.com.stefanini.developerup.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Embeddable
public class EmprestarPk implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	
	
	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;
	
	
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
	@Override
	public int hashCode() {
		return Objects.hash(cliente, livro);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmprestarPk other = (EmprestarPk) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(livro, other.livro);
	}
	
	

}
