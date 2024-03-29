package jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = -2377824445278332521L;
	private Integer id;
	private String nome;
	private Endereco endereco;
	private List<Pedido> pedidos;
	
	
	//construtor padrão
	public Cliente() {
		
	}


	public Cliente( String nome) {
		this.nome = nome;
		this.pedidos = new ArrayList<Pedido>();
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	//bean validation
	@NotBlank(message = "Faltou o nome do cliente")
	@Size(min=4 , max=45)
	//jpa
	@Column(length = 45, nullable = false)
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@OneToOne(cascade = CascadeType.PERSIST)
	public Endereco getEndereco() {
		return endereco;
	}
	
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "cliente")
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
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
		Cliente other = (Cliente) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("Cliente ID: %-5d Nome: %-s %s", id, nome, endereco);
	}

}