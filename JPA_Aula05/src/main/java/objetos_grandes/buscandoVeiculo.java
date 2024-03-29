package objetos_grandes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import jakarta.persistence.EntityManager;
import jpa.util.JpaUtil;

public class buscandoVeiculo {
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Integer id =  1;
		Veiculo v = em.find(Veiculo.class, id);
		System.out.println(v.getDescricao());
		
		ImageIcon foto = new ImageIcon(v.getFoto());
		JOptionPane.showInternalMessageDialog(null, new JLabel(foto),
					v.getMarca() + " " + v.getModelo(), JOptionPane.PLAIN_MESSAGE);
		
		em.close();
		JpaUtil.close();
	}
}
