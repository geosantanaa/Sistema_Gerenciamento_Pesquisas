package br.com.start.model.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
public class PlanoDeTrabalhoEntradaDto {


	@ApiModelProperty(example = "Avanços da Tecnologia", value = "Titulo da Pesquisa do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size(max = 200, message = "máximo permitido é 200 caracters")
	private String tituloPesquisa;

	@ApiModelProperty(example = "002343", value = "Numero do Projeto do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size(max = 200, message = "máximo permitido é 200 caracters")
	private String numeroProjeto;

	@ApiModelProperty(example = "CIENCIA_EXTAS_E_DA_TERRA", value = "Area de conhecimento do Plano de Pesquisa", required = true)
	@NotNull
	@Pattern(regexp = "CIENCIA_EXTAS_E_DA_TERRA|CIENCIAS_BIOLOGICAS|ENGENHARIAS|CIENCIAS_DA_SAUDE|CIENCIAS_SOCIAIS_APLICADAS|CIENCIAS_HUMANAS|LINGUISTICA_LETRAS_E_ARTES")
	private String areaDeConhecimento;

	@ApiModelProperty(example = "Tecnologia", value = "Nome do Grupo de Pesquisa", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size(max = 200, message = "máximo permitido é 200 caracters")
	private String nomeGrupoPesquisa;
		
	@ApiModelProperty(example = "1", value = "Id do Professor/Orientador vinculado ao Plano de Trabalho", required = true)
	@NotNull
	private Long professorId;
	
	@ApiModelProperty(example = "[1,2,3]", value = "Id dos alunos vinculado ao Plano de Trabalho", required = true)
	@NotNull
	private List <Long> alunosId;


}
