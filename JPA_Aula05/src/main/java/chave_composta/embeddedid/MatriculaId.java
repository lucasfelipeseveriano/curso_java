package chave_composta.embeddedid;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MatriculaId implements Serializable{
	private static final long serialVersionUID = -5895299752574893186L;
	
	@Column(name = "id_aluno")
	private Integer idAluno;
	
	@Column(name = "id_turma")
	private Integer idTurma;
	
	
	public Integer getIdAluno() {
		return idAluno;
	}
	
	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}
	
	public Integer getIdTurma() {
		return idTurma;
	}
	
	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}


}
