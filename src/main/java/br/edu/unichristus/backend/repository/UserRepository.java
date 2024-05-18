package br.edu.unichristus.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.User;


public interface UserRepository 
					extends JpaRepository<User, Long>{
	
	public Optional<User> findByLogin(String login);
	
}
