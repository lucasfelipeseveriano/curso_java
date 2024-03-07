package com.softgraf.primavera.rest;

public class ProdutoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ProdutoNotFoundException(Long id) {
		super("Não foi possiel encontrar o id=" + id);
	}

}
