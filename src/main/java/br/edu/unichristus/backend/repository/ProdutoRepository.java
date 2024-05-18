package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Produto;


public interface ProdutoRepository 
					extends JpaRepository<Produto, Long>{
	
	public Optional<Produto> findByEan(String i);
	
}
