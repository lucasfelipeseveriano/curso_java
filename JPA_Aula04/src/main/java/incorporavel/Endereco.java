package incorporavel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public class Endereco {

	private String rua;
	private String cidade;
	private String uf;
	
	
	// ALT S R
	
	@Column(length = 45)
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@Column(length = 20, nullable = false)
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Column(length = 2, nullable = false)
	@NotBlank(message = "Faltou Estado")
	@Size(max = 2, min = 2)
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
