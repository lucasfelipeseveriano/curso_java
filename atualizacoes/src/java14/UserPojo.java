package java14;

import java.util.Objects;

public class UserPojo {
	
	private String nome;
	private String senha;
	
	public UserPojo() {

	}
	
	public UserPojo(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UserPojo [nome=" + nome + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPojo other = (UserPojo) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha);
	}
	
	

}
