package jpql.parametros;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.util.JpaUtil;
import jpql.modelo.Famoso;

public class ConsultaComParemetros {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
				
		String jpql = "select f from Famoso f where f.nome = :nomePessoa or f.pais = :paisOrigem";
		
		TypedQuery<Famoso> query = em.createQuery(jpql, Famoso.class);
		query.setParameter("nomePessoa", "Bill Gates");
		query.setParameter("paisOrigem", "Brasil");
		query.getResultList().forEach(f -> System.out.println(f.getNome()));
		
		String jpq2 = "select f from Famoso f where f.nome = ?1 or f.pais = ?2";
		
		TypedQuery<Famoso> query2 = em.createQuery(jpql, Famoso.class);
		query2.setParameter(1, "Bill Gates");
		query2.setParameter(2, "Brasil");
		query2.getResultList().forEach(f -> System.out.println(f.getNome()));
				
		em.clear();
		JpaUtil.close();
	}

}
