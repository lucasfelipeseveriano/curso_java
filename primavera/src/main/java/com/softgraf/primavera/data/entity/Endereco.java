package com.softgraf.primavera.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
@EqualsAndHashCode(of = {"rua", "cep"})
@Embeddable
public class Endereco {
	
	@Column(length = 30)
	private String rua;
	
	@Column(length = 20)
	private String bairro;
	
	@NotBlank(message = "Cidade é obrigatória")
	@Size(min = 3, max = 30)
	@Column(length = 30, nullable = false)
	private String cidade;
	
	@NotBlank(message = "Estaso é obrigatório")
	@Column(length = 20, nullable = false)
	private String estado;
	
	@Column(length = 9)
	private String cep;

}
