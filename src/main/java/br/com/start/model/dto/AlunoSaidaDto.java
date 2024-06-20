package br.com.start.model.dto;

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
public class AlunoSaidaDto {

	private Long id;
	private String nome;
//	private Indicacao indicacao;
//	private OrdemIndicacao ordemIndicacao;
	private String ra;
	private String cpf;
	private String rg;
	private Curso curso;
	private String emailInstitucional;
	private String contato;
	private PlanoDeTrabalho planoDeTrabalho;

}
