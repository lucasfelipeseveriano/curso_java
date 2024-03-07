package com.softgraf.agenda.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;



/**
 * <strong> Sistema de agenta com arquivo binário <strong>
 * <a href="https://softgraf.com">
 * 
 * @author Lucas
 * @version 1.0
 * @since 10-06-2023
 *
 */




public class ArquivoBinario {

	private RandomAccessFile arquivo;
	
	
	/**
	 * <p> Método responsável por abrir ou criar um arquivo binário de dados<p>
	 * @param nome é o arquivo a ser aberto ou criado
	 * @see
	 * 	
	 * @since 10-06-2023
	 * @throws IOException Se não for possível abrir ou criar arquivo 
	 * 
	 * 
	 */
	
	public void abrirArquivo(String nome) throws IOException {
		arquivo = new RandomAccessFile(nome, "rw");
		
		arquivo.seek(arquivo.length());
	}
	
	/**
	 * 
	 * @throws IOException Se não for possível fechar o arquivo 
	 */
	public void fecharArquivo() throws IOException {
		if (arquivo !=null) {
			arquivo.close();
			arquivo = null;
				
		}
	}
	
	
	/**
	 * 
	 * @param contato objeto Contato para salvar 
	 * @see com.softgraft.agenda.model.Contato
	 * @throws IOException Se o arquivo ainda não foi aberto
	 */
	public void gravarContato(Contato contato) throws IOException {
		// TODO Auto-generated method stub
		arquivo.seek(arquivo.length());
		arquivo.writeInt(contato.getId());
		
		arquivo.writeChars(limitarStrings(contato.getNome(),20));
		arquivo.writeChars(limitarStrings(contato.getNome(),10));

		
	}

		private String limitarStrings(String campo, int tamanhoMaximo) {
			int diferenca = tamanhoMaximo - campo.length();
			StringBuilder sb = new StringBuilder(tamanhoMaximo);
			
			if (diferenca > 0) {
				char[] arrChar = new char [diferenca];
				
				Arrays.fill(arrChar, ' ');
				sb.append(campo);
				sb.append(arrChar);
				
				
				
			}else {
				sb.append(campo.substring(0, tamanhoMaximo));
			}
			
			return sb.toString();
			
		}
		
		/**
		 * 
		 * @param numero É a posição do registro no arquivo: 1..n
		 * @return conato ou null
		 * @throws IOException Se o Contato ainda não foi aberto
		 */
		public Contato lerContato(int numero) throws IOException {
			Contato contato = null;
			
			if (arquivo != null) {
				contato = new Contato();
				
				arquivo.seek((numero - 1) * 64);
				
				int id = arquivo.readInt();
				contato.setId(id);
				
				StringBuilder nome = new StringBuilder(20);
				for (int i=0; i<20; i++) {
					nome.append(arquivo.readChar());
					
				}
				contato.setNome(nome.toString().trim());
				
				StringBuilder fone = new StringBuilder(10);
				for (int i=0; i<10; i++) {
					fone.append(arquivo.readChar());
				}
				
				contato.setFone(fone.toString().trim());
						
				
			} else {
				throw new IOException ("Nenhum arquivo aberto para leitura");
			}
			return contato;
		}

		/**
		 * 
		 * @return int retorna o total de registros exitentes 
		 * @throws IOException
		 */
		public int quantidadeRegistros() throws IOException {
			int quant = 0;
			
			if (arquivo != null) {
				quant = (int) arquivo.length() / 64;
				
			} else {
				throw new IOException("Nenhum aquivo aberto para leitura");
			}
			
			return quant;
		}
		
		/**
		 * @deprecated será removido a partir da versão 2.0
		 */
		@Deprecated
		public void metodoDepreciado() {
			
		}
	
	
}
