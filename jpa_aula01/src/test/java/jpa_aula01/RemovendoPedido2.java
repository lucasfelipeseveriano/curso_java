package jpa_aula01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.entity.Pedido;
import jpa.util.JpaUtil;

public class RemovendoPedido2 {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEbtityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Integer id = 3;
		Pedido pedido = em.find(Pedido.class, id);
		
		pedido.setCliente(null);
		em.remove(pedido);
		
		tx.commit();
		em.close();
		JpaUtil.close();
		
	}

}
