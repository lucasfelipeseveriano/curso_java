package jpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	public static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("jpa_pu");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
		
	}
	
	public static void close() {
		emf.close();
	}


}
