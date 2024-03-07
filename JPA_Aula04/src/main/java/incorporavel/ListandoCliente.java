package incorporavel;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class ListandoCliente {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Cliente> cliente = em.createQuery("from Cliente", Cliente.class).getResultList();
		
		cliente.forEach(c -> {	
			System.out.println(c.getId());
			System.out.println(c.getNome());
			
			Endereco e = c.getEndereco();
			System.out.println(e.getRua());
			System.out.println(e.getCidade());
			System.out.println(e.getUf());
		});
		
	}

}
