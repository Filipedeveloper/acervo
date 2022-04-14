package br.com.stefanini.developerup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "livro")
public class Livro extends PanacheEntityBase implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String anoPublicacao;
	private String editora;
	private String isbn;
	private Integer quantidade;
	
	
	@ManyToOne
	@JoinColumn(name="autor_id")
	private Autor autor;
	
	@JsonIgnore
    @Transient
    
	@OneToMany(mappedBy = "id.livro")
	private Set<Emprestar> emprestimos = new HashSet<Emprestar>();
	
	
	
	public Livro() {
		super();
	}



	public Livro(Integer id, String nome, String anoPublicacao, String editora, String isbn, Integer quantidade, Autor autor) {
		super();
		this.id = id;
		this.anoPublicacao = anoPublicacao;
		this.editora = editora;
		this.isbn = isbn;
		this.quantidade = quantidade;
		this.autor = autor;
		this.nome = nome;
	}
	
	
	public List<Livro> getLivros(){
		List<Livro> livros = new ArrayList<Livro>();
		for(Emprestar e : emprestimos) {
			livros.add(e.getLivro());
		}
		
		return livros;
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
	public Autor getAutor() {
		return autor;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
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
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}



	public Set<Emprestar> getEmprestimos() {
		return emprestimos;
	}



	public void setEmprestimos(Set<Emprestar> emprestimos) {
		this.emprestimos = emprestimos;
	}




	
	

}
