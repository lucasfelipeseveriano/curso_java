package com.softgraf.primavera.data.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import com.softgraf.primavera.data.model.GrupoCnpj;
import com.softgraf.primavera.data.model.GrupoCpf;
import com.softgraf.primavera.data.model.TipoPessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id", "nome"})

@Table(name = "clientes")
@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Tipo de pessoa é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", length = 8)
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message = "nome é obrigatorio")
	@Size(max = 60, min = 3)
	@Column(length = 60, nullable = false)
	private String nome;
	
	@NotBlank(message = "CPF/CNPJ é obrigatorio")
	@CPF(groups = GrupoCpf.class)
	@CNPJ(groups = GrupoCnpj.class)
	@Column(name = "cpf_cnpj", nullable = false)
	private String cpfOUCnpj;
	
	@Size(max = 60)
	@Email(message = "E-mail inválido")
	@Column(length = 60)
	private String email; 
	
	@Column(length = 14)
	private String fone;
	
	@Embedded
	private String endereco;

	
}
