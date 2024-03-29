package jpql.modelo;

import java.io.Serializable;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;


@NamedQueries({
	@NamedQuery(name = "Famoso.listarTodos", query = "from  Famoso"),
	@NamedQuery(name = "Famoso.listarAmericanos", query = "select f from Famoso f where f.pais = 'Estados Unidos'"),
	@NamedQuery(name = "Famoso.listarCantores", query = "select f from Famoso f where f.profissao = 'Cantor'"),
})

@Entity
public class Famoso implements Serializable{

	private static final long serialVersionUID = 3220264317913178353L;
	
	//para uso apenas com NamedQueries
	public final static String LISTAR_TODOS = "Famoso.listarTodos";
	public final static String LISTAR_AMERICANOS = "Famoso.listarAmericanos";
	public final static String LISTAR_CANTORES = "Famoso.listarCantores";
	
	private Integer id;
	private String nome;
	private String pais;
	private String profissao;
	
	public Famoso() {

	}
	
	public Famoso( String nome, String pais, String profissao) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.profissao = profissao;
	}

	@Id
	@GeneratedValue
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
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}


	
	
	

}
