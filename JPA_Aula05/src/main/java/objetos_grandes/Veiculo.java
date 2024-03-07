package objetos_grandes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 20)
	private String marca;
	
	@Column(length = 60)
	private String modelo;
	
	@Lob
	private String descricao;
	
	@Lob
	private byte[] foto;
	
	@Transient
	private String naoSalvo;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNaoSalvo() {
		return naoSalvo;
	}

	public void setNaoSalvo(String naoSalvo) {
		this.naoSalvo = naoSalvo;
	}
	

}
