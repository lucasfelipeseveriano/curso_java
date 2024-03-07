package login;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class ConsultandoLogin {
	

public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		// consulta ou query = JPQL
		em.createQuery("from Login", Login.class).getResultList().forEach(System.out::println);
		
		em.close();
		JpaUtil.close();
	}

}
