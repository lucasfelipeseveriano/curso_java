package jpql.bulk_operations;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jpa.util.JpaUtil;
import jpql.native_query.Funcionario;

public class OperacoesEmLote {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		List<Funcionario> lista = em.createQuery("from tbl_funcionarios", Funcionario.class).getResultList();
		
	//lista.forEach(f -> {
	//		double salario = f.getSalario();
	//		f.setSalario(salario * 1.1);
	//	});
		
		Query q1 = em.createQuery("UPDATE tbl_funcionarios f SET f.salario = f.salario * 1.3");
		q1.executeUpdate();
		
		Query q2 = em.createQuery("DELETE tbl_funcionarios f where f.salario > 10000");
		q2.executeUpdate();
		
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
