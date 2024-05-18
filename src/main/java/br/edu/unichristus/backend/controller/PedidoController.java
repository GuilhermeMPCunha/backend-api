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

import br.edu.unichristus.backend.data.dto.PedidoDTO;
import br.edu.unichristus.backend.data.dto.PedidoLowDTO;
import br.edu.unichristus.backend.data.model.Pedido;
import br.edu.unichristus.backend.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@Operation(summary = "Cadastrar usuário | role: [ADMIN]", 
			tags = "Pedido", description = "Possibilita "
					+ "cadastrar um pedido a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Pedido retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Pedido informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public PedidoLowDTO save(@RequestBody PedidoDTO pedido) {
		return service.save(pedido);
	}
	
	@PutMapping
	public PedidoLowDTO update(@RequestBody PedidoDTO pedido) {
		return service.save(pedido);
	}
	
	@GetMapping("/all")
	public List<PedidoLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Pedido findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
	

}
