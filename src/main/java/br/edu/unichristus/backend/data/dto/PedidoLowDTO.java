package br.edu.unichristus.backend.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoLowDTO {
	
	private Long id;
	
	@JsonProperty("nome")
	private String numero;
	private String totalPedido;
	
}
