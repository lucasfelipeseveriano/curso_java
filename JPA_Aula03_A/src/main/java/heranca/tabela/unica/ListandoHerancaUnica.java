package heranca.tabela.unica;

import java.util.List;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class ListandoHerancaUnica {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		
		List<Medicamento> medicamentos = em.createQuery("from Medicamento", Medicamento.class).getResultList();
		medicamentos.forEach(m -> System.out.printf("ID: %-5d Descrição: %-20s\n", m.getId(), m.getDescricao()));
		
		List<Produto> produtos = em.createQuery("from tbl_produtos", Produto.class).getResultList();
		produtos.forEach(p -> System.out.printf("ID: %-5d Descrição: %-20s\n", p.getId(), p.getDescricao()));
		
		em.close();
		JpaUtil.close();
	}

}
