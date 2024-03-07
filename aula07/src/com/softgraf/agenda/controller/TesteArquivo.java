package com.softgraf.agenda.controller;

import java.io.IOException;

import com.softgraf.agenda.model.ArquivoBinario;
import com.softgraf.agenda.model.Contato;

public class TesteArquivo {
	
	public static void main(String[] args) {
		Contato c1 = new Contato(1, "João da silva", "3222-0707");
		Contato c2 = new Contato(2,"Carlos Pereira", "3344-0804");
		Contato c3 = new Contato(3, "Luiz da Silva", "1234-0987");
		Contato c4 = new Contato(4, "felipe da Silva","4325-0987");
		
		ArquivoBinario arq = new ArquivoBinario();
		
		try {
			System.out.println("Salvando registros...");
			arq.abrirArquivo("agenda.dat");
//			arq.gravarContato(c1);
//			arq.gravarContato(c2);
//			arq.gravarContato(c3);
//			arq.gravarContato(c4);
//			
//			System.out.println("\n Lendo registros");
			System.out.println(arq.lerContato(2));
		
			
			arq.fecharArquivo();
		} catch (IOException e) {
			System.out.println("Erro ao abrir/gravar/ler arquivo agenda.data");
			e.printStackTrace();
			System.exit(0);
		}
		
	}

}
