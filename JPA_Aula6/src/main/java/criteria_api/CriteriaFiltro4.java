package criteria_api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jpa.util.JpaUtil;
import modelo.Livro;

public class CriteriaFiltro4 {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Livro> criteriaQuery= builder.createQuery(Livro.class);
		Root<Livro> livro = criteriaQuery.from(Livro.class);

		Predicate predicate = builder.greaterThan(livro.get("preco"), 50.00);

		criteriaQuery.where(predicate);
		
		criteriaQuery.select(livro);
		
		TypedQuery<Livro> query = em.createQuery(criteriaQuery);
		query.getResultList().forEach(System.out::println);
		
		em.close();
		JpaUtil.close();
	}

}
