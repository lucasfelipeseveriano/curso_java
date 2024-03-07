package consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class ConsultaEspecial {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		String jpql = "select e.nome, count(e) from Estudante e join e.cursos group by e order by e.nome asc";
		List<Object[]> lista = em.createQuery(jpql, Object[].class).getResultList();
		
		for (Object[] tupla : lista) {
			System.out.printf("%-10s %d\n", tupla[0], tupla[1]);
		}
		
		em.close();
		JpaUtil.close();

	}
}
