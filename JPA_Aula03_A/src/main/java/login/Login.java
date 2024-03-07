package login;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;

@Entity
public class Login implements Serializable {

	private static final long serialVersionUID = 5586430381551944018L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 255, nullable = false)
	private String senha;
	
	protected static String nomeLogado = null;
	
	public Login() {
		
	}
		
	
	public Login(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}
	
	// CALLBACKS
	@PrePersist
	public void prePersist() {
		System.out.println("Vai persistir login...");
	}
	
	@PostPersist
	public void postPersist() {
		System.out.println("Persistiu!");
	}
	
	@PostLoad
	public void postLoad() {
		System.out.println("carregou: " +nome);
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Login other = (Login) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {

		return String.format("ID: %-5d Nome: %-15s Senha:%-20s", id, nome, senha);
	}
	
}
