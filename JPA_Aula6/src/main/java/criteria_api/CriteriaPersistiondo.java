package criteria_api;

import java.math.BigDecimal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;
import modelo.Autor;
import modelo.Livro;

public class CriteriaPersistiondo {
	
	public static void main(String[] args) {
		
		Livro livro1 = new Livro("Lógica de Programação", new BigDecimal("39.90"));
		Livro livro2 = new Livro("Algoritmos", new BigDecimal("49.90"));
		Livro livro3 = new Livro("Estrurura de Dados", new BigDecimal("59.90"));
		Livro livro4 = new Livro("IA", new BigDecimal("69.90"));
		
		
		
		Autor autor1 = new Autor("Joseph");
		autor1.getLivros().add(livro2);
		
		Autor autor2 = new Autor("James");
		autor2.getLivros().add(livro3);
		autor2.getLivros().add(livro4);
		
		Autor autor3 = new Autor("George");
		autor3.getLivros().add(livro1);
		
		Autor autor4 = new Autor("Deitel");
		autor4.getLivros().add(livro2);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		em.persist(autor4);
		
		tx.commit();
		em.close();
		JpaUtil.close();
		}

}
