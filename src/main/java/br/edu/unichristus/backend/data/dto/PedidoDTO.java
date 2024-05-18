package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {
	
	private Long id;
	
	private String data;
	private String status;
	private int quantidade;
	private float totalPedido;
	private String numero;
	
	
	
}
