package jpql.native_query;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;

@NamedNativeQueries({
	@NamedNativeQuery(name = "Funcionario.listarTodos", query = "select * from tbl_funcionarios", resultClass = Funcionario.class),
	@NamedNativeQuery(name = "Funcionario.ordenarPorNome", query = "select * from tbl_funcionarios order by nome", resultClass = Funcionario.class),
	@NamedNativeQuery(name = "Funcionario.ordenarPorSalario", query = "select * from tbl_funcionarios order by salario", resultClass = Funcionario.class),
	@NamedNativeQuery(name = "Funcionario.listarCidade", query = "select  distinct upper(cidade) from tbl_funcionarios")
})


@Entity(name = "tbl_funcionarios")
public class Funcionario {
	
	public final static String LISTAR_TODOS = "Funcionario.listarTodos";
	public final static String ORDENAR_POR_NOME = "Funcionario.ordenarPorNome";
	public final static String ORDENAR_POR_SALARIO = "Funcionario.ordenarPorSalario";
	public final static String LISTAR_CIDADE = "Funcionario.listarCidade";
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private Double salario;
	private String cidade;
	
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario(String nome, Double salario, String cidade) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.cidade = cidade;
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


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	@Override
	public String toString() {
		return String.format("id: %-5d Nome: %-20s Salario: RS %-10.2f Cidade: %s", id, nome, salario, cidade);
	}
	
	

}
