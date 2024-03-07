package criteria_api;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jpa.util.JpaUtil;
import modelo.Livro;

public class CriteriaConcultando {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<Livro> criteriaQuery= builder.createQuery(Livro.class);
		
		Root<Livro> livro = criteriaQuery.from(Livro.class);
		
		criteriaQuery.select(livro);
		
		TypedQuery<Livro> query = em.createQuery(criteriaQuery);
		
		List<Livro> lista = query.getResultList();
		
		lista.forEach(System.out::println);
		
		em.close();
		JpaUtil.close();
	}

}
