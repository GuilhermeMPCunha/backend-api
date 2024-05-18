package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.PedidoDTO;
import br.edu.unichristus.backend.data.dto.PedidoLowDTO;
import br.edu.unichristus.backend.data.model.Pedido;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	public PedidoLowDTO save(PedidoDTO pedidoDTO) {
		var pedidoModel = DozerConverter.parseObject(pedidoDTO, Pedido.class);
	    if (!pedidoModel.getStatus().equalsIgnoreCase("aprovado") && 
	            !pedidoModel.getStatus().equalsIgnoreCase("reprovado")) {
	            throw new CommonsException(
	                HttpStatus.BAD_REQUEST,
	                "unichristus.backend.service.pedido.badrequest.exception",
	                "Status do pedido deve ser 'aprovado' ou 'reprovado'!"
	            );
	        }
		var pedidoFind = repository.findByNumero(pedidoModel.getNumero());
		if(!pedidoFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.pedido.conflict.exception",
					"O Numero de Pedido informado já existe!"
					);
		}
		
		
		var pedidoSaved = repository.save(pedidoModel);
		
		var pedidoLowDTO = DozerConverter.parseObject(pedidoSaved, PedidoLowDTO.class);
		
		return pedidoLowDTO;
	}
	
	public List<PedidoLowDTO> listAll(){
		var listPedidoLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listPedidoLow, PedidoLowDTO.class);
		
		return listConverted;
	}
	

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Pedido findById(Long id) {
		var pedido = repository.findById(id);
		if(pedido.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.pedido.notfound.exception",
					"O Pedido com a ID informada, não foi encontrado."
					);
		}
		
		return pedido.get();
	}

}
