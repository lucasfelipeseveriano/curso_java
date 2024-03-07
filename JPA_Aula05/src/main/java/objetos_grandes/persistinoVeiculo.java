package objetos_grandes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.util.JpaUtil;

public class persistinoVeiculo {
	
	public static void main(String[] args) throws IOException {
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Veiculo v= new Veiculo();
		v.setMarca("VW");
		v.setMarca("Polo");
		v.setDescricao("""
				
				Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum
				
				""");
		
		Path path = FileSystems.getDefault().getPath("f:/veiculo.jpg");
		byte[] foto = Files.readAllBytes(path);
		v.setFoto(foto);
		
		em.persist(v);
		
		tx.commit();
		em.clear();
		JpaUtil.close();
	}
}
