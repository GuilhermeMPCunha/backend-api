package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Vendedor;


public interface VendedorRepository 
					extends JpaRepository<Vendedor, Long>{
	
	public Optional<Vendedor> findByCnpj(String cnpj);

	public Optional<Vendedor> findByLogin(String login);
	
}
