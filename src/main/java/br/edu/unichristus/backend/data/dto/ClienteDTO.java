package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {
	
	private Long id;
	
	private String nome;
	private String email;
	private String login;
	private String password;
	private String cpf;
	private String numCartao;
	private String cep;
	
}
