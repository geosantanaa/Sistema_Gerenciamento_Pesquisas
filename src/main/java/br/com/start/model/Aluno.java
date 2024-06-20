package br.com.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 200)
	private String nome;
	
//	@Column(nullable = false, length = 200)
//	private Indicacao indicacao;
	
//	@Column(nullable = false, length = 200)
//	private OrdemIndicacao ordemIndicacao;
	
	@Column(nullable = false, length = 50)
	private String ra;
	
	@Column(nullable = false, length = 50)
	private String cpf;
	
	@Column(nullable = false, length = 50)
	private String rg;
	
	@Column(nullable = false, length = 150)
	private Curso curso;
	
	@Column(name = "email_institucional", nullable = false, length = 200)
	private String emailInstitucional;
	
	@Column(nullable = false, length = 200)
	private String contato;
	
	@ManyToOne
	private PlanoDeTrabalho planoDeTrabalho;
	
	
	}
