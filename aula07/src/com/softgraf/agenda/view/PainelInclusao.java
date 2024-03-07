package com.softgraf.agenda.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.softgraf.agenda.model.Contato;
import com.softgraf.agenda.model.DAO;
import com.softgraf.agenda.model.Dialogo;

public class PainelInclusao extends JPanel {
	private static final long serialVersionUID = 532563463073781482L;
	private FlowLayout layout;
	private PainelContato pnlContato;
	private JButton btnSalvar;
	private JTextField txtAviso;
	private Contato contato;

	public PainelInclusao(Dimension tamanho) {
		// TODO Auto-generated constructor stub
		contato = new Contato();
		
		try {
			int quant = DAO.getArquivo().quantidadeRegistros();
			contato.setId(quant + 1);
			
		} catch (IOException e) {
			Dialogo.erro("erro fatal ao ler o arquivos de dados");
			e.printStackTrace();
			System.exit(0);
		}
		
		layout= new FlowLayout(FlowLayout.CENTER, 10,10);
		setLayout(layout);
		//                       R   G   B
		setBackground(new Color(220,255,255));
		setPreferredSize(tamanho);
		
		pnlContato = new PainelContato(contato, true);
		add(pnlContato);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoSalvar());
		add(btnSalvar);
		
		txtAviso = new JTextField(22);
//		txtAviso.setBackground(getBackground());
		txtAviso.setForeground(Color.red);
		txtAviso.setEditable(false);
		txtAviso.setHighlighter(null);
		txtAviso.setBorder(null);
		add(txtAviso);	
		}
	
	private class AcaoSalvar implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (contato.getNome().length() < 6 ||
				contato.getFone().length() < 8)
				txtAviso.setText("dados incompletos!");
			else {
				
				
				try {
					DAO.getArquivo().gravarContato(contato);
					int id = contato.getId();
					contato = new Contato();
					contato.setId(id + 1);
					pnlContato.setContato(contato);					
					txtAviso.setText("Salvou!");
					
				} catch (IOException e1) {
					e1.printStackTrace();
					Dialogo.erro("Erro ao salvar contato");
				}
				
			}
		}
		
	}

}
