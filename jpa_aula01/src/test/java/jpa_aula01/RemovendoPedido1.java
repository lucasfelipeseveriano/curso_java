package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.entity.Pedido;
import jpa.util.JpaUtil;

public class RemovendoPedido1 {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEbtityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Integer id = 3;
		Pedido pedido = em.find(Pedido.class, id);
		
		try {
			em.remove(pedido);
			System.out.println("\nPedido removido");
			
		} catch (Exception e){
			System.out.println("\nPedido não pode ser removido por estar referenciado no Cliente");
			e.printStackTrace();
			
			/*
			 *  soluções para remover dependências
			 *  - remover o cliente - melhor não!
			 *  - user CascadaType.REMOVE em Pedido.getCliente() - melhor não!
			 *  - remover a dependencia Cliente no pedido
			 * 
			 */
		}
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}

}
