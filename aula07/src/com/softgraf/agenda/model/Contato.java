package com.softgraf.agenda.model;

public class Contato {
	
	private int id;
	private  String nome;
	private String fone;
	public Contato() {
		
		
	}
	
	/**
	 * Construtur com 3 parâmetros
	 * @param id coresponde a uma chave prímaria
	 * @param nome Nome completo do contato
	 * @param fone
	 */
	public Contato(int id, String nome, String fone ) {
		this.id = id;
		this.nome = nome;
		this.fone = fone;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String toString() {
		return String.format("ID: %-5d Nome: %-20s Fone: %s", id, nome, fone);
	}

}
