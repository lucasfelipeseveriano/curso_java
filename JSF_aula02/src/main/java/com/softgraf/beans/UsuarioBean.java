package com.softgraf.beans;

import java.io.Serializable;



@SuppressWarnings("serial")

public class UsuarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String enviar() {
		return "pag2";
	}
	
	public String redirecionar() {
		return "pag2?faces-redirect=true";
	}
	


}
