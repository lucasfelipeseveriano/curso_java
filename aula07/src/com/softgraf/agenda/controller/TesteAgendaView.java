package com.softgraf.agenda.controller;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.softgraf.agenda.model.DAO;
import com.softgraf.agenda.view.AgendaView;
import com.softgraf.agenda.view.PainelConsulte;
import com.softgraf.agenda.view.PainelInclusao;
import com.softgraf.agenda.view.PainelTabela;

public class TesteAgendaView {
	
	public static void main(String [] args) {
		
		DAO.abrir();
		Dimension tamanho = new Dimension(300,200);
		JPanel pnlInclusao = new PainelInclusao(tamanho);
		JPanel pnlConsulte = new PainelConsulte(tamanho);
		JPanel pnlTabela = new PainelTabela(tamanho);
		
		AgendaView janela = new AgendaView (pnlInclusao, pnlConsulte, pnlTabela);
		janela.setVisible(true);
		
	}

}
