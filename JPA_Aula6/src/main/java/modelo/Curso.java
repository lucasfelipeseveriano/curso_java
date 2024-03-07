package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 45)
	private String nome;
	
	@Column(precision = 10, scale = 2)
	private BigDecimal preco;

	@ManyToMany(mappedBy = "cursos")
	private Set<Estudante> estudantes = new HashSet<>();
	
	
	public Curso() {
	}


	public Curso(String nome, BigDecimal preco) {
		super();
		this.nome = nome;
		this.preco = preco;
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


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public void setEstudantes(Set<Estudante> estudantes) {
		this.estudantes = estudantes;
	}
	
	public Set<Estudante> getEstudantes() {
		return estudantes;
	}
	
	public void addEstudante(Estudante estudante) {
		this.estudantes.add(estudante);
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
}
