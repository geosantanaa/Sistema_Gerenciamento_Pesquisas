package br.com.start.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 200)
	private String nome;

	@Column(name = "email_institucional", length = 200)
	private String emailInstitucional;

	@Column(nullable = false, length = 10)
	private String senha;

	@Column(nullable = false, length = 200)
	private String nivelOrientador;

	@Column(nullable = false, length = 200)
	private String matricula;

	@Column(nullable = false, length = 200)
	private Curso curso;

	@Column(nullable = false, length =200)
	private String cpf;

	@Column(nullable = false, length = 200)
	private String contatoOrientador;

	@OneToMany(mappedBy = "professor")
	private List<PlanoDeTrabalho> planosDeTrabalho;

}
