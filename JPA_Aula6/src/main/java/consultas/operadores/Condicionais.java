package consultas.operadores;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;
import modelo.Estudante;
import static java.lang.System.out;

public class Condicionais {
	static EntityManager em;
	
	public static void main(String[] args) {
		em = JpaUtil.getEntityManager();
		
		query("Menor", "select e from Estudante e where e.idade < 18");
		query("Between", "select e from Estudante e where e.idade BETWEEN 18 AND 20");
		query("Empty", "select e from Estudante e where e.cursos IS EMPTY");
		query("Like", "select e from Estudante e where e.nome LIKE 'gab%'");
		query("IN", "select e from Estudante e where e.nome IN ('Gabriel', 'Ariel')");
		query("MEMBER OF", "select e from Estudante e, Cursoc where e MEMBER OF c.estudantes");
		
		
		em.close();
		JpaUtil.close();
	}
	
	private static void query(String msg, String consulta) {
		System.out.println(msg);
		em.createQuery(consulta, Estudante.class).getResultList().forEach(out::println);
		System.out.println();
		
	}
	
}
