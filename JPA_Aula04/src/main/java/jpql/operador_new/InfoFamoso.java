package jpql.operador_new;

public class InfoFamoso {

	private String nome;
	private String pais;
	
	
	public InfoFamoso(String nome, String pais) {
		super();
		this.nome = nome;
		this.pais = pais;
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
	
	@Override
	public String toString() {
		return String.format("Nome: %-15s Pais: %s", nome, pais);
	}
	
	
}
