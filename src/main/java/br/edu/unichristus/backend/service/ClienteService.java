package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.ClienteDTO;
import br.edu.unichristus.backend.data.dto.ClienteLowDTO;
import br.edu.unichristus.backend.data.dto.PedidoDTO;
import br.edu.unichristus.backend.data.model.Cliente;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	public ClienteLowDTO save(ClienteDTO clienteDTO) {
		var clienteModel = DozerConverter.parseObject(clienteDTO, Cliente.class);
		if(clienteModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.cliente.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		var clienteModelCep = DozerConverter.parseObject(clienteDTO, Cliente.class);
		if(clienteModelCep.getCep().length() > 8) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.cliente.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		var clienteFind = repository.findByCpf(clienteModel.getCpf());
		if(!clienteFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.cliente.conflict.exception",
					"O CPF informado já existe!"
					);
		}
		
		var clienteFindLogin = repository.findByLogin(clienteModel.getLogin());
		if(!clienteFindLogin.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.cliente.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		
		var clienteSaved = repository.save(clienteModel);
		
		var clienteLowDTO = DozerConverter.parseObject(clienteSaved, ClienteLowDTO.class);
		
		return clienteLowDTO;
	}
	
	public List<ClienteLowDTO> listAll(){
		var listClienteLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listClienteLow, ClienteLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Cliente findById(Long id) {
		var cliente = repository.findById(id);
		if(cliente.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.cliente.notfound.exception",
					"O cliente com a ID informada, não foi encontrado."
					);
		}
		return cliente.get();
	}
	
	// novo codigo
	public List<PedidoDTO> getPedidosByCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
