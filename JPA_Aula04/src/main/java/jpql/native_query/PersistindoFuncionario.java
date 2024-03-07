package jpql.native_query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;

public class PersistindoFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Gilberto Amaral", 9330.0 , "Ponta Grossa");
		Funcionario f2 = new Funcionario("Luiz Machado", 4500.0 , "Ipiranga");
		Funcionario f3 = new Funcionario("Carlos Oliveira", 8000.0 , "Carambei");
		Funcionario f4 = new Funcionario("Alison Santos", 5400.0 , "Castro");
		Funcionario f5 = new Funcionario("Vitor Oliveira", 4500.0 , "Irati");
		Funcionario f6 = new Funcionario("Adan Amaral", 5800.0 , "Palmeira");
		Funcionario f7 = new Funcionario("Nicole Amaral", 4000.0 , "Maringa");
		Funcionario f8 = new Funcionario("Lucas Santos", 7800.0 , "Colombo");
		Funcionario f9 = new Funcionario("Felipe Santos", 6200.0 , "Curitiba");
		Funcionario f10 = new Funcionario("Peter França", 7750.0 , "Londrina");
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction ex = em.getTransaction();
		ex.begin();
		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		em.persist(f5);
		em.persist(f6);
		em.persist(f7);
		em.persist(f8);
		em.persist(f9);
		em.persist(f10);
		ex.commit();
		em.close();
		JpaUtil.close();
	}

}
