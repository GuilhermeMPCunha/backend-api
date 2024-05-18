package br.edu.unichristus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Backend da API marktplace",
	        version = "1.0",
	        description = "Trata-se da Documentação da API construída para o marktplace",
	        contact = @Contact(
	        	    name = "Guilherme Cunha",
	        	    email = "guilhermempcunha10@gmail.com",
	        	     url = "https://unichristus.edu.br")
	    )
	)

public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

}
