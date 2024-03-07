package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@Entity
public class Autor implements Serializable {

	private static final long serialVersionUID = -8245662831572660729L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 45)
	private String nome;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "autor_livro", joinColumns = @JoinColumn(name="autor_id"), inverseJoinColumns = @JoinColumn(name="livro_id"))
	private Set<Livro> livros = new HashSet<>();

	public Autor() {
		
	}
	
	public Autor(String nome) {
		super();
		this.nome = nome;
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

	public Set<Livro> getLivros() {
		return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return String.format("Autor id: %-5d Nome: %s", id, nome);
	}
	
	
}
