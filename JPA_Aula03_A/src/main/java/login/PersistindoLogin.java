package login;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;

public class PersistindoLogin {
	public static void main(String[] args) {
		
		EntityManager em= JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Login rafael = new Login("Rafael", "123");
		Login gabriel= new Login("Gabriel", "456");
		Login ariel = new Login("Ariel", "789");
		
		tx.begin();
		

		
		em.persist(rafael);
		em.persist(gabriel);
		em.persist(ariel);
		
		tx.commit();
		em.close();
		JpaUtil.close();
		
	}

}
