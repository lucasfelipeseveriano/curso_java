package com.softgraf.primavera.data.dto;

import com.softgraf.primavera.data.entity.Produto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRecordDTO(
		
		//Bean validation
		@NotBlank(message = "Descrição do produto é obrigatório")
		String descricao,
		
		@DecimalMin(value = "0.0", inclusive = false, message = "Preço abaixo do mínimo")
		@DecimalMax(value =  "9999.0", message = "Preço acima do máximo")
		Float preco,
		
		@NotNull(message = "Quantidade é obrigatória")
		@Min(1)
		@Max(9999)
		Integer quantidade,
		
		@Column(length = 255)
		String url
		
	) {
	
	public Produto toProduto() {
		return new Produto(descricao, preco, quantidade);
	}

}
