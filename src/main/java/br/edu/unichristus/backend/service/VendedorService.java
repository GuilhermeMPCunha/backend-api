package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.VendedorDTO;
import br.edu.unichristus.backend.data.dto.VendedorLowDTO;
import br.edu.unichristus.backend.data.model.Vendedor;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;

	public VendedorLowDTO save(VendedorDTO vendedorDTO) {
		var vendedorModel = DozerConverter.parseObject(vendedorDTO, Vendedor.class);
		if(vendedorModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.vendedor.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		
		var vendedorModelCep = DozerConverter.parseObject(vendedorDTO, Vendedor.class);
		if(vendedorModelCep.getCep().length() > 8) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.vendedor.badrequest.exception",
					"Limite de caracteres excedido! Digite apenas os 8 numeros do cep"
					);
		}
		
		var vendedorFind = repository.findByCnpj(vendedorModel.getCnpj());
		if(!vendedorFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.vendedor.conflict.exception",
					"O CNPJ informado já existe!"
					);
		}
		
		var vendedorFindLogin = repository.findByLogin(vendedorModel.getLogin());
		if(!vendedorFindLogin.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.vendedor.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		
		var vendedorSaved = repository.save(vendedorModel);
		
		var vendedorLowDTO = DozerConverter.parseObject(vendedorSaved, VendedorLowDTO.class);
		
		return vendedorLowDTO;
	}
	
	public List<VendedorLowDTO> listAll(){
		var listVendedorLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listVendedorLow, VendedorLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Vendedor findById(Long id) {
		var vendedor = repository.findById(id);
		if(vendedor.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.vendedor.notfound.exception",
					"O vendedor com a ID informada, não foi encontrado."
					);
		}
		return vendedor.get();
	}

}
