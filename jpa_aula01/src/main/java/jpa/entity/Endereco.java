package jpa.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = -4416565712503363305L;
	private Integer id;
	private String rua;
	private String cidade;
	private String uf;

	public Endereco() {
	}

	public Endereco(String rua, String cidade, String uf) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.uf = uf;
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	@Column(length = 45)
	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	@NotBlank(message = "falta a cidade")
	@Size(min=3, max=20)
	@Column(length= 20, nullable =false)
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@NotBlank(message= "faltou estado")
	@Size(min=2, max=2)
	@Column(length= 2, nullable= false)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return String.format("id: %-5d cidade: %-15d rua: %-15d uf: %-15d", id, cidade, rua, uf);
	
	}

}