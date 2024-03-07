package com.softgraf.agenda.model;

import java.io.IOException;

public class DAO {
	
	private static ArquivoBinario arquivo = null;
	
	public static void abrir() {
		arquivo = new ArquivoBinario();
		
		try {
			arquivo.abrirArquivo("agenda.dat");
			
		} catch(IOException e) {
			Dialogo.erro("Não foi possível abrir/criar agenda.dat");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static ArquivoBinario getArquivo() {
		return arquivo;
	}
	
	public static void fechar() {
		try {
			arquivo.fecharArquivo();
			
		} catch(IOException e) {
			Dialogo.erro("Não foi possível fechar arquivo agenda.dat");
			e.printStackTrace();
		}
		
	}

}
