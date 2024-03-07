package com.softgraf.primavera.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@EqualsAndHashCode
public class AutoridadeId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "username",length = 50, nullable = false)
	private String nomeUsuario;
	
	@Column(name = "authority", length = 50, nullable = false)
	private String autorizacao;

}
