package br.edu.unichristus.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.backend.data.model.Cliente;
import br.edu.unichristus.backend.data.model.Pedido;


public interface PedidoRepository 
					extends JpaRepository<Pedido, Long>{
	
	public Optional<Pedido> findByNumero(String numero);

	public List<Pedido> findByCliente(Cliente cliente);
	
}
