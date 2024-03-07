package consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;
import modelo.Estudante;

public class ConsultaJoinFetch {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		String jpql = "select e from Estudante e join fetch e.cursos c where c.nome='Curso de Java";
		List<Estudante> estudante = em.createQuery(jpql, Estudante.class).getResultList();
		
		estudante.forEach(e -> {
			System.out.println("\n" + e);
			e.getCursos().forEach(System.out::println);
		});
		
		em.close();
		JpaUtil.close();
	}

}
