package br.com.stefanini.developerup.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "emprestar")
public class Emprestar extends PanacheEntityBase implements Serializable {
	
	
	 
	private static final long serialVersionUID = 1L;
	
	

	@EmbeddedId
	private EmprestarPk id = new EmprestarPk(); 
	
	private String dataInicio;
	private String dataEntrega;
	private String status;
	
	public Emprestar() {
		super();
	}

	public Emprestar(Cliente cliente, Livro livro, String dataInicio, String dataEntrega, String status) {
		super();
		id.setCliente(cliente);
		id.setLivro(livro);
		this.dataInicio = dataInicio;
		this.dataEntrega = dataEntrega;
		this.status = status;
	}
	
	
	
	public Cliente getCliente() {
		return id.getCliente();
	}
	
	public Livro getLivro() {
		return id.getLivro();
	}

	public EmprestarPk getId() {
		return id;
	}

	public void setId(EmprestarPk id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestar other = (Emprestar) obj;
		return Objects.equals(id, other.id);
	}
	

}
