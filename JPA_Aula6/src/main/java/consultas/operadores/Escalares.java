package consultas.operadores;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;
import modelo.Curso;

public class Escalares {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
	
		// ALL
		// todos os valores da sudconsulta
		System.out.println("\nALL----------------------------------");
		em.createQuery("select c from Curso c where c.preco >= ALL (select c.preco from Curso c)", Curso.class).getResultList().forEach(System.out::println);
		
		
		// ANY
		// um dos valores do intervalo
		System.out.println("\nANY----------------------------------");
		em.createQuery("select c from Curso c where c.preco >= ANY (select c.preco from Curso c)", Curso.class).getResultList().forEach(System.out::println);
		
		
		// SOME
		// um valor da subconsulta
		System.out.println("\nSOME---------------------------------");
		em.createQuery("select c from Curso c where c.preco >= SOME (select c.preco from Curso c)", Curso.class).getResultList().forEach(System.out::println);
	
		
		em.close();
		JpaUtil.close();

	}
}
