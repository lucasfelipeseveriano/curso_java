package com.softgraf.agenda.model;



public class Contato {
	
	private Long id;
	private String nome;
	private String phone;
	
	
	public Contato() {	}
	
	public Contato(String nome, String phone ) {
		this(null, nome, phone);
		
	}
	
	public Contato(Long id, String nome, String phone ) {
		this.id = id;
		this.nome = nome;
		this.phone = phone;
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFone() {
		return phone;
	}
	public void setFone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return String.format("ID: %-5d Nome: %-20s Fone: %s", id, nome, phone);
	}

}
