package consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;
import modelo.Estudante;

public class ConsultaSimples {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Estudante> estudantes = em .createQuery("from Estudante", Estudante.class).getResultList();
			
		estudantes.forEach(e -> {
			System.out.println("\n" + e);
			e.getCursos().forEach(System.out::println);
		});
		
		em.close();
		JpaUtil.close();
	}
}
