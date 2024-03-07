package consultas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;
import modelo.Estudante;

public class BuscaeagerOuLazy {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Estudante e1 = em.find(Estudante.class, 1);
		
		System.out.println(e1.getNome());
		
		Estudante e2 = em.getReference(Estudante.class, 1);

		System.out.println(e2.getNome());
		
		
		em.close();
		JpaUtil.close();
	}
}
