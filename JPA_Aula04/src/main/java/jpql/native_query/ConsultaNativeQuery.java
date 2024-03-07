package jpql.native_query;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class ConsultaNativeQuery {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		List<?> todos = em.createNativeQuery("select * from tbl_funcionarios", Funcionario.class).getResultList();
		todos.forEach(s -> System.out.println(s));
		
		System.out.println("------------------------------------------------------------------------------------");
		em.createNamedQuery(Funcionario.ORDENAR_POR_NOME,Funcionario.class).getResultList().forEach(System.out::println);
		
		System.out.println("------------------------------------------------------------------------------------");
		em.createNamedQuery(Funcionario.ORDENAR_POR_SALARIO,Funcionario.class).getResultList().forEach(System.out::println);
		
		System.out.println("------------------------------------------------------------------------------------");
		em.createNamedQuery(Funcionario.LISTAR_CIDADE).getResultList().forEach(System.out::println);
		
		
		Object total = em.createNativeQuery("select avg(salario) from tbl_funcionarios").getSingleResult();
		
		System.out.println("\n=======> Média salarial R$ " + total);
		
		
		em.close();
		JpaUtil.close();
	}

}
