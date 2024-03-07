package login;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.util.JpaUtil;

public class Autenticacao {
	
	public static void autenticar(String nome, String senha) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Login>query = em.createQuery("select log from Login log where log.nome = :nome AND log.senha = :senha", Login.class);
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
		if (query.getResultList().isEmpty()) {
			System.out.println("Login incorreto");
			Login.nomeLogado = null;
		} else {
			System.out.println("Você logou");
			Login.nomeLogado = nome;
		}
		
		
		em.close();
		JpaUtil.close();
	}

}
