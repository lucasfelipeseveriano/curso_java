package incorporavel;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;

public class PersistindoSuco {
	public static void main(String[] args) {
		Suco suco1 = new Suco();
		suco1.setMarca("Campo Largo");
		List<String> sabores1 = Arrays.asList("uva", "laranja");
		suco1.setSabores(sabores1);
		
		Suco suco2 = new Suco();
		suco2.setMarca("Campo Largo");
		List<String> sabores2 = Arrays.asList("uva", "limão", "laranja", "abacaxi", "kiwi");
		suco2.setSabores(sabores1);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(suco1);
		em.persist(suco2);
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
