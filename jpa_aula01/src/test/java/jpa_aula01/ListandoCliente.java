package jpa_aula01;

import jakarta.persistence.EntityManager;
import jpa.entity.Pedido;
import jpa.util.JpaUtil;

public class ListandoCliente {
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEbtityManager();
		
		// JPQL = Java Persistence Query Language
		em.createQuery("from Pedido", Pedido.class).getResultList().forEach(System.out::println);
		
		em.clear();
		JpaUtil.close();
		
		}

	
}

