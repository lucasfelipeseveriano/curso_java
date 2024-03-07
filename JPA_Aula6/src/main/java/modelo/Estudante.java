package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

@Entity
public class Estudante implements Serializable{

	private static final long serialVersionUID = -5672552369471183952L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 45)
	private String nome;
	private Integer idade;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "matriculados", joinColumns = @JoinColumn(name="estudante_id"), inverseJoinColumns = @JoinColumn(name="curso_id"))
	private Set<Curso> cursos = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "emprestimos", joinColumns = @JoinColumn(name="estudante_id"), inverseJoinColumns = @JoinColumn(name="livro_id"))
	private List<Livro> livros = new ArrayList<>();
	
	public Estudante() {
	}

	
	public Estudante(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;	
	
	}

	@PrePersist
	public void preoPersist() {
		System.out.println("\nSalvando estudande...");
	}
	
	@PostPersist
	public void postPersist() {
		System.out.println("\nEstudante salvo");
	}
	
	@PreUpdate
	public void preUpdate() {
		System.out.println("\nAtualizando estudantes...");
	}
	
	@PreRemove
	public void preRemove() {
		System.out.println("\nRemovendo estudante...");
	}
	
	@PostRemove
	public void postRemove() {
		System.out.println("\nEstudante removido");
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


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	
	public Set<Curso> getCursos() {
		return cursos;
	}
	
	
	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	public void matricular(Curso curso) {
		this.cursos.add(curso);
		curso.addEstudante(this);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	private void gatlivro() {
		// TODO Auto-generated method stub

	}
	
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
}	
	