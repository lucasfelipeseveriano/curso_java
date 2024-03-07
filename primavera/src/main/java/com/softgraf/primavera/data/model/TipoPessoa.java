package com.softgraf.primavera.data.model;

public enum TipoPessoa {

	FISICA("Física", GrupoCpf.class),
	JURIDICA("juridica", GrupoCnpj.class);
	
	private final String descricao;
	private final Class<?> grupo;
	
	TipoPessoa(String descricao, Class<?> grupo) {
		this.descricao = descricao;
		this.grupo = grupo;
	}
	
	String getDescricao() {
		return descricao;
	}
	
	Class<?> getGrupo(){
		return grupo;
	}
}
