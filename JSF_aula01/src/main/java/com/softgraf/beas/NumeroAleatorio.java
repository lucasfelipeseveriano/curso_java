package com.softgraf.beas;

import java.io.Serializable;



@SuppressWarnings("serial")

public class NumeroAleatorio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int maximo;
	private int numeroAleatorio;
	
	public String geraNumeroAleatorio() {
		this.numeroAleatorio = (int) (Math.random()* this.maximo);
		return "resposta";
	}

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getNumeroAleatorio() {
		return numeroAleatorio;
	}

	public void setNumeroAleatorio(int numeroAleatorio) {
		this.numeroAleatorio = numeroAleatorio;
	}

	
	
}
