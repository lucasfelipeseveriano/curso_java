package jpql.Subconsulta;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;
import jpql.modelo.Famoso;

public class Subconsulta {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		String jpql = "select p from Famoso p where p.nome like 'B%' and exists (select f from famoso f where f.pais = 'Estados Unidos')";
		
		List<Famoso> lista = em.createQuery(jpql, Famoso.class).getResultList();	
		
		if (lista.isEmpty())
			System.out.println("Ninguem encontrado");
		else
			System.out.println(lista.get(0).getNome());
		
		em.clear();
		JpaUtil.close();
	}
}
