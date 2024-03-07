package com.softgraf.agenda.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.softgraf.agenda.model.Contato;
import com.softgraf.agenda.model.DAO;
import com.softgraf.agenda.model.Dialogo;

public class PainelTabela extends JPanel {
	
	private static final long serialVersionUID = -6277439822081994834L;

	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private String[] colunas;
	private List<Contato> contatos;

	private ArrayList contato;
	
	// construtor
	public PainelTabela(Dimension tamnho) {
		setBackground(new Color(255, 255, 200));
		
		// nome das colulas
		colunas = new String[] {"ID", "NOME", "FONE"};
		
		// estrutura de dados
		tableModel = new DefaultTableModel();
		
		// adiciona colulas na tabela
		tableModel.addColumn(colunas[0]);
		tableModel.addColumn(colunas[1]);
		tableModel.addColumn(colunas[2]);
		
		
		carregarContatos();
		for (Contato c : contatos) {
			
			String[] linha = {String.valueOf(c.getId()), c.getNome(), c.getFone()};
			tableModel.addRow(linha);
		}
		
		
		table =  new JTable(tableModel);
		
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(tamnho);
		
		add(scroll, BorderLayout.CENTER);
		
	}

	private void carregarContatos() {
		contatos = new ArrayList<>();
		try {
			int quant = DAO.getArquivo().quantidadeRegistros();
			
			if (quant > 0) {
				for(int i=1; i<=quant; i++) {
					Contato contato = DAO.getArquivo().lerContato(i);	
					contatos.add(contato);
				}
			}
			
		}catch (IOException e) {
			Dialogo.erro("");
			
		}
	}

}
