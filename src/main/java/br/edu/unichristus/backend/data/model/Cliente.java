package br.edu.unichristus.backend.data.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String nome;
	private String email;
	
	@Column(unique = true)
	private String login;
	private String password;
	private String cpf;
	private String numCartao;
	
	@Column(nullable = false, length = 8)
	private String cep;
	
	
	//Codigo novo
	
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
	

}
