package br.com.start.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.start.model.Curso;
import br.com.start.model.PlanoDeTrabalho;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ApiModel
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfessorSaidaDto {
	
	private Long id;
	private String nome;
	private String emailInstitucional;
	private String senha;
	private String nivelOrientador;
	private String matricula;
	private Curso curso;
	private String cpf;
	private String contatoOrientador;
	private List <PlanoDeTrabalho> planoDeTrabalho;

}

