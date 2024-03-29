package jpql.operador_new;

import java.util.List;
import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class ConsultaSelectNew {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		String jpql = "select new jpql.operador_new.InfoFamoso(f.nome, f.pais) from Famoso f";
		
		List<InfoFamoso> lista = em.createQuery(jpql, InfoFamoso.class).getResultList();
		
		lista.forEach(System.out::println);
		
		em.close();
		JpaUtil.close();
	}

}
