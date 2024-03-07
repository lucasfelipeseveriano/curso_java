package com.softgraf.agenda.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AgendaView extends JFrame{

	private static final long serialVersionUID = -3169463646271405393L;
	private JTabbedPane painelAbas;
	
	public AgendaView(JPanel pnlInclusao, JPanel pnlConsulta, JPanel pnlTabela) {
		super("Agenda 1.0 ");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	
		painelAbas = new JTabbedPane();
		painelAbas.addTab ("inclusão", pnlInclusao);
		painelAbas.addTab("Consulta",pnlConsulta);
		painelAbas.addTab("Tabela", pnlTabela);
		setContentPane(painelAbas);
		
		setSize(800,600);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void dispose() {
		System.out.println("Fechou arquivo");
		super.dispose();
	}
	
	

}
