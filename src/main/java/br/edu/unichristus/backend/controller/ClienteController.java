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

import br.edu.unichristus.backend.data.dto.ClienteDTO;
import br.edu.unichristus.backend.data.dto.ClienteLowDTO;
import br.edu.unichristus.backend.data.dto.PedidoDTO;
import br.edu.unichristus.backend.data.model.Cliente;
import br.edu.unichristus.backend.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@Operation(summary = "Cadastrar cliente | role: [ADMIN]", 
			tags = "Cliente", description = "Possibilita "
					+ "cadastrar um cliente a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Cliente retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Cpf informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public ClienteLowDTO save(@RequestBody ClienteDTO cliente) {
		return service.save(cliente);
	}
	
	@PutMapping
	public ClienteLowDTO update(@RequestBody ClienteDTO cliente) {
		return service.save(cliente);
	}
	
	@GetMapping("/all")
	public List<ClienteLowDTO> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@GetMapping
	public Cliente findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}
	
    // Novos endpoints para lidar com pedidos de um cliente
    @GetMapping("/{id}/pedidos")
    public List<PedidoDTO> getPedidosByCliente(@PathVariable Long id) {
        return service.getPedidosByCliente(id);
    }

}
