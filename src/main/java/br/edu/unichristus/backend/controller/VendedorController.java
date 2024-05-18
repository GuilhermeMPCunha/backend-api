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

import br.edu.unichristus.backend.data.dto.VendedorDTO;
import br.edu.unichristus.backend.data.dto.VendedorLowDTO;
import br.edu.unichristus.backend.data.model.Vendedor;
import br.edu.unichristus.backend.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService service;
	
	@Operation(summary = "Cadastrar usuário | role: [ADMIN]", 
			tags = "Vendedor", description = "Possibilita "
					+ "cadastrar um vendedor a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Vendedor retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public VendedorLowDTO save(@RequestBody VendedorDTO vendedor) {
		return service.save(vendedor);
	}
	
	@PutMapping
	public VendedorLowDTO update(@RequestBody VendedorDTO vendedor) {
		return service.save(vendedor);
	}
	
	@GetMapping("/all")
	public List<VendedorLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Vendedor findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	

}
