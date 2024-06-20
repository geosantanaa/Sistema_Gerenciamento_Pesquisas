package br.com.start.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.start.model.Aluno;
import br.com.start.model.AreaDeConhecimento;
import br.com.start.model.Professor;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanoDeTrabalhoSaidaDto {


	private Long id;
	private String tituloPesquisa;
	private String numeroProjeto;
	private AreaDeConhecimento areaDeConhecimento;
	private String nomeGrupoPesquisa;
	private Professor professor;
	private List <Aluno> alunos;

}
