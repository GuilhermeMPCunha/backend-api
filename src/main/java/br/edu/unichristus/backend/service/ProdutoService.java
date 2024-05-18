package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.ProdutoDTO;
import br.edu.unichristus.backend.data.dto.ProdutoLowDTO;
import br.edu.unichristus.backend.data.model.Produto;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	public ProdutoLowDTO save(ProdutoDTO produtoDTO) {
		var produtoModel = DozerConverter.parseObject(produtoDTO, Produto.class);
		if(produtoModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.user.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		var produtoModelDesc = DozerConverter.parseObject(produtoDTO, Produto.class);
		if(produtoModelDesc.getDescricao().length() > 500) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.user.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		
		var produtoFind = repository.findByEan(produtoModel.getEan());
		if(!produtoFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.user.conflict.exception",
					"O EAN informado já existe!"
					);
		}
		
		
		var ProdutoSaved = repository.save(produtoModel);
		
		var ProdutoLowDTO = DozerConverter.parseObject(ProdutoSaved, ProdutoLowDTO.class);
		
		return ProdutoLowDTO;
	}
	
	public List<ProdutoLowDTO> listAll(){
		var listUserLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listUserLow, ProdutoLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Produto findById(Long id) {
		var user = repository.findById(id);
		if(user.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.user.notfound.exception",
					"O produto com a ID informada, não foi encontrado."
					);
		}
		return user.get();
	}

}
