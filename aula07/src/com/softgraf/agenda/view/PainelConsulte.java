package com.softgraf.agenda.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JSlider;
import com.softgraf.agenda.model.Contato;
import com.softgraf.agenda.model.DAO;
import com.softgraf.agenda.model.Dialogo;

public class PainelConsulte extends JPanel {
	
	private static final long serialVersionUID = -3786560864057885931L;
	private FlowLayout layout;
	private PainelContato pnlContato;
	private JSlider slider;
	private Color corFundo;

	public PainelConsulte(Dimension tamanho) {
		corFundo = new Color(255, 220, 255);
		
		layout = new FlowLayout(FlowLayout.CENTER, 10,10);
		setLayout(layout);
		setBackground(corFundo);
		setPreferredSize(tamanho);
		addComponentListener(new AcaoExibir());
		
		pnlContato = new PainelContato(new Contato(), false);
		add(pnlContato);
		
		slider = new JSlider(JSlider.HORIZONTAL, 1, 1, 1);
		slider.setPreferredSize(new Dimension(tamanho.width - 50, 50));
		slider.setBackground(corFundo);
		slider.setLabelTable(slider.createStandardLabels(1));
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setEnabled(false);
		slider.addChangeListener(e -> {
			mostrarRegistros();
		});
		
		add(slider);
		
	}
	
	private class AcaoExibir extends ComponentAdapter{
		@Override
		public void componentShown(ComponentEvent e) {
			mostrarRegistros();
		}
	}

	private void mostrarRegistros() {
		int quant = 0; 
		
		try {
			quant = DAO.getArquivo().quantidadeRegistros();
		} catch (IOException e) {
			Dialogo.erro("Erro");
		}
		
		if (quant > 0) {
			slider.setEnabled(true);
			slider.setMaximum(quant);
			
			int numero = slider.getValue();
			try {
				Contato contato = DAO.getArquivo().lerContato(numero);
				pnlContato.setContato(contato);
				
			} catch (IOException e) {
				Dialogo.erro("Erro ao ler o registro " + numero + " de agenda.dat");
			}
		}else {
			slider.setEnabled(false);
		}
		
	}

}
