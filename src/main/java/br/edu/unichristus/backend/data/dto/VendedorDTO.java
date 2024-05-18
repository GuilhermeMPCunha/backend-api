package br.edu.unichristus.backend.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendedorDTO {
	
	private Long id;
	
	private String nome;
	private String email;
	private String login;
	private String password;
	private String cnpj;
	private String contaBancaria;
	private String cep;
	private String categoria;
	
}
