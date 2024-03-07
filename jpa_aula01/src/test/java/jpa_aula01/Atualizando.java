package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.entity.Cliente;
import jpa.entity.Endereco;
import jpa.util.JpaUtil;

public class Atualizando {
	
	public static void main(String[] args) {
		
	}
	
	private static void salvar() {
		Endereco rua = new Endereco("AV. Vicente Machado, 001", "Curitiba", "PR");
		Cliente luiz = new Cliente("Luiz Carlos");
		luiz.setEndereco(rua);
		
		EntityManager em = JpaUtil.getEbtityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(luiz);
		
		tx.commit();
		em.close();
		JpaUtil.close();
		
	}
	
	private static void atualizar() {	
		EntityManager em = JpaUtil.getEbtityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		// recupera o cliente Luiz pelo id
		Integer id = 2;
		Cliente cliente = em.find(Cliente.class, id);
		
		cliente.setNome("Luiz Carlos de Oliveira");
		
		cliente.getEndereco().setRua("Rua Balduino Taques, 77");
		cliente.getEndereco().setCidade("Ponta Grossa");
		
				
		
		tx.commit();
		em.close();
		JpaUtil.close();
		
	}

}
