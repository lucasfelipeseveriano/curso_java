package modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;

public class TesteCallback {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Estudante e = em.find(Estudante.class, 8);
		
		e.setNome("Mariana");
		
		em.remove(e);
		
		tx.commit();
		em.close();
		JpaUtil.close();
		
		}
}
