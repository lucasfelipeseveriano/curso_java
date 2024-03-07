package com.softgraf.beas;

import java.io.Serializable;

public class TextoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String texto = "Texto do Bean";
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String paraMaiusculas() {
		this.texto= this.texto.toUpperCase();
		return "destino";
	}
	
	
}
