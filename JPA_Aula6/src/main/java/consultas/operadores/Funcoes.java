package consultas.operadores;

import static java.lang.System.out;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;
import modelo.Estudante;

public class Funcoes {
	static EntityManager em;
	
	public static void main(String[] args) {
		em = JpaUtil.getEntityManager();
		
		funcao("CONCAT", "select CONCAT(e.nome, ' - ', c.nome) from Estudante e, Curso c where e MEMBER OF c.estudantes order by e.nome ASC");
		
		funcao("DISTINCT", "select DISTINCT c.nome from Curso c");
		
		funcao("CURRENT_DATE", "select CURRENT_DATE from Curso");
		
		funcao("LENGTH", "select LENGTH(c.nome) from Curso c");
		
		funcao("LOCATE", "select c.nome from Curso c where LOCATE('java', c.nome) > 0");
		
		funcao("SUBSTRING", "select SUBSTRING(c.nome, 10, length(c.nome)) from Curso c");
		
		funcao("TRIM", "select TRIM(LEADING 'Curso de ' from c.nome) from Curso c");
		funcao("TRIM", "select TRIM(TRILINGH 'Python' from c.nome) from Curso c");
		funcao("TRIM", "select TRIM(BOTH ' ' from c.nome) from Curso c");
		
		funcao("LOWER", "select LOWER(c.nome) FROM Curso c");
		
		funcao("UPPER", "select UPPER(c.nome) FROM Curso c");
		
		funcao("SIZE", "select CONCAT(c.nome, ' - ', SIZE(e.cursos), 'cursos') from Estudante e");
		
		funcao("ABS", "select ABS(c.preso) from Curso c");
		
		funcao("MOD", "select MOD(5, 2) from Curso");
		
		funcao("SQRT", "select SQRT(81) from Curso ");


		
		em.close();
		JpaUtil.close();
	}
	
	private static void funcao(String msg, String consulta) {
		System.out.println(msg);
		em.createQuery(consulta, Estudante.class).getResultList().forEach(out::println);
		System.out.println();
		
	}

}
