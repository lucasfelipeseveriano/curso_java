package consultas.operadores;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class Agregadores {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
	
		// count
		Long count = em.createQuery("select COUNT(c) from Curso c", Long.class).getSingleResult();
		System.out.println("Quantidade de cursos: " + count);
		
		// max
		BigDecimal max = em.createQuery("select MAX(c.preco) from Curso", BigDecimal.class).getSingleResult();
		System.out.printf("\nPreço máximo: R$ %.2f", max);
		
		// min
		BigDecimal min = em.createQuery("select MIN(c.preco) from Curso", BigDecimal.class).getSingleResult();
		System.out.printf("\nPreço mínimo: R$ %.2f", min);
		
		// avg
		Double avg = em.createQuery("select AVG(c.preco) from Curso", Double.class).getSingleResult();
		System.out.printf("\nPreço médio: R$ %.2f", avg);
		
		// sum
		BigDecimal sum = em.createQuery("select SUM(c.preco) from Curso", BigDecimal.class).getSingleResult();
		System.out.printf("\nTotal: R$ %.2f", sum);
		
		em.close();
		JpaUtil.close();
	}
}
