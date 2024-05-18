package br.edu.unichristus.backend.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.dto.ProdutoDTO;
import br.edu.unichristus.backend.data.dto.ProdutoLowDTO;
import br.edu.unichristus.backend.data.model.Produto;
import br.edu.unichristus.backend.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@Operation(summary = "Cadastrar produto | role: [ADMIN]", 
			tags = "Produto", description = "Possibilita "
					+ "cadastrar um produto a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Produto retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Ean informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public ProdutoLowDTO save(@RequestBody ProdutoDTO produto) {
		return service.save(produto);
	}
	
	@PutMapping
	public ProdutoLowDTO update(@RequestBody ProdutoDTO produto) {
		return service.save(produto);
	}
	
	@GetMapping("/all")
	public List<ProdutoLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Produto findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	

}
