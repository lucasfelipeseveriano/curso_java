package janelas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame implements MouseListener{
	
	public Janela() {
		System.out.println("chamou o construtor");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Primeiera janela");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setLocation(300, 500);
		btnOk.setSize(80, 30);
		add(btnOk);
		
		addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicou no mouse");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println();
		
	}
	

}
