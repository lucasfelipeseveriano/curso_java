package chave_composta.embeddedid;

import java.time.LocalDate;

import chave_composta.idclass.DataUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.util.JpaUtil;

public class Buscando {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		int codAluno = 1;
		int codTurma = 2;
		
		MatriculaId matriculaId = new MatriculaId();
		matriculaId.setIdAluno(codAluno);
		matriculaId.setIdTurma(codTurma);
		
		Matricula mat = em.find(Matricula.class, matriculaId);
		System.out.println("\n--- Buscando Matricula com find()");
		System.out.println(mat);
		
		String jpql = "select m from Matricula m where m.idAluno = :codAluno AND m.idTurma = :codTurma";
		TypedQuery<Matricula> query = em.createQuery(jpql, Matricula.class);
		query.setParameter("codAluno", codAluno);
		query.setParameter("codTurma", codTurma);
		System.out.println("\n--- Buscando Matricula com query()");
		System.out.println(query.getSingleResult());
		
		jpql = "select m.dataMatricula from Matricula m where m.idAluno = ?1 AND m.idTurma = ?2";
		TypedQuery<LocalDate> query2 = em.createQuery(jpql, LocalDate.class);
		query2.setParameter(1, codAluno);
		query2.setParameter(2, codTurma);
		LocalDate date = query2.getSingleResult();
		System.out.println("\nApenas data: " + DataUtil.formatarData(date));
		
		em.close();
		JpaUtil.close();
	}
}
