package chave_composta.idclass;

import java.io.Serializable;


public class MatriculaId implements Serializable{
	private static final long serialVersionUID = -5895299752574893186L;
	
	private Integer idAluno;
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
