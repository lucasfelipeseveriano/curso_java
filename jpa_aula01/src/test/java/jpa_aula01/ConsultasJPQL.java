package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jpa.entity.Cliente;
import jpa.entity.Endereco;
import jpa.util.JpaUtil;

public class ConsultasJPQL {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEbtityManager();
		
		System.out.println("\n--- Todos os Clientes");
		em.createQuery("from Cliente", Cliente.class).getResultList().forEach(System.out::println);	
		
		System.out.println("Busca Cliente por nome");
		TypedQuery<Cliente> queryPorNome = em.createQuery("from Cliente c where c.nome like '%jos%'", Cliente.class);
		queryPorNome.getResultList().forEach(System.out::println);
		
		// Listando todos os endereços dos Clientes
		TypedQuery<Endereco> queryEnderecos = em.createQuery("select c.endereco from Cliente c where c.endereco != null", Endereco.class);
		queryEnderecos.getResultList().forEach(System.out::println);
		
		// Buscando nome da cidade do Cliente José
		TypedQuery<String> queryCidadeJose = em.createQuery("select c.endereco.cidade from Cliente c where c.nome like '%jos%'", String.class);
		queryCidadeJose.getResultList().forEach(System.out::println);
		
		
		
		em.clear();
		JpaUtil.close();
	}

}
