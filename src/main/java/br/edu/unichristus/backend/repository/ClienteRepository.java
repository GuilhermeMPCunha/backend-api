package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Cliente;


public interface ClienteRepository 
					extends JpaRepository<Cliente, Long>{
	
	public Optional<Cliente> findByCpf(String cpf);
	
	public Optional<Cliente> findByLogin(String login);
	
}
