package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
	
	private Long id;
	
	private String nome;
	private String descricao;
	private int estoque;
	private float preco;
	private String ean;
	
}
