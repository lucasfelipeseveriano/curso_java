package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 400701139104845209L;
		
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 60)
	private String titulo;
	
	@Column(precision = 5, scale = 2)
	private BigDecimal preco;
	
	@ManyToMany(mappedBy = "livros", cascade = CascadeType.PERSIST)
	private List<Estudante> estudantes = new ArrayList<>();

	
	public Livro() {
		
	}

	public Livro(String titulo, BigDecimal preco) {
		super();
		this.titulo = titulo;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<Estudante> getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(List<Estudante> estudantes) {
		this.estudantes = estudantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo);
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
		return Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return String.format("Livro id: %-5d Titulo: %-30s Preço: %s", id, titulo, preco);
	}
	
	
}
