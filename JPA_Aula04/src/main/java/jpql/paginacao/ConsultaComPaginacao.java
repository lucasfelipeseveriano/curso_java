package jpql.paginacao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.util.JpaUtil;
import jpql.native_query.Funcionario;

public class ConsultaComPaginacao {
	public static void main(String[] args) {
		int inicio = 0;
		final int TAMANHO_PAGINA = 5;
		
		EntityManager em = JpaUtil.getEntityManager();
		
		TypedQuery<Funcionario> query = em.createQuery("from tbl_funcionarios", Funcionario.class);
		
		query.setFirstResult(inicio);
		query.setMaxResults(TAMANHO_PAGINA);
		
		System.out.println("================= Pag 1 =================");
		query.getResultList().forEach(System.out::println);
		
		inicio += TAMANHO_PAGINA;
		query.setFirstResult(inicio);
		query.setMaxResults(TAMANHO_PAGINA);
		System.out.println("================= Pag 2 =================");
		query.getResultList().forEach(System.out::println);
		
		
		em.close();
		JpaUtil.close();
	}

}
