package criteria_api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jpa.util.JpaUtil;
import modelo.Livro;

public class CriteriaFiltro1 {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();

		// idem exemplo anterior
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Livro> criteriaQuery= builder.createQuery(Livro.class);
		Root<Livro> livro = criteriaQuery.from(Livro.class);

		// para fazer a filtragem, primeiro precisamos de um objeto Predicate
		Predicate predicate = builder.equal(livro.get("titulo"), "algoritmos");

		// e adicionamos o predicate na cláusula where
		criteriaQuery.where(predicate);
		
		// depois usamos o select
		criteriaQuery.select(livro);
		
		// finalmente criamos a typed query e obtemos o resultado
		TypedQuery<Livro> query = em.createQuery(criteriaQuery);
		query.getResultList().forEach(System.out::println);
		
		em.close();
		JpaUtil.close();
	}

}
