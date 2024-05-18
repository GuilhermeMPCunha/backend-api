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
public class ClienteLowDTO {
	
	private Long id;
	
	@JsonProperty("nome")
	private String name;
	private String email;
	
}
