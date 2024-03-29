package chave_composta.embeddedid;

import java.time.LocalDate;

import chave_composta.idclass.Aluno;
import chave_composta.idclass.MatriculaId;
import chave_composta.idclass.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;

public class Persistindo {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Aluno aluno = new Aluno();
		aluno.setNome("Carlos dos Santos");
		
		Turma turma = new Turma();
		turma.setDescricao("Turma de javacript");
		
		
		em.persist(aluno);
		em.persist(turma);
		
		MatriculaId matriculaId = new MatriculaId();
		matriculaId.setIdAluno(aluno.getId());
		matriculaId.setIdTurma(turma.getId());
		
		Matricula matricula = new Matricula();
		matricula.setId(matriculaId);
		matricula.setDataMatricula(LocalDate.of(2023, 8, 5));
		
		em.persist(matricula);
		
		tx.commit();
		em.close();
		JpaUtil.close();
		}

}
