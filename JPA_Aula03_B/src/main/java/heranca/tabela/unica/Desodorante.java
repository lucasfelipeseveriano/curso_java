package heranca.tabela.unica;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "desodorante_id")
public class Desodorante extends Produto{

	private static final long serialVersionUID = -2780962003655849249L;
	private Integer quantidade;

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
