package br.com.start.model.dto;

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
public class AlunoEntradaDto {

	@ApiModelProperty(example= "Maria Santos",value="Nome do ALuno", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String nome;
	
//	@ApiModelProperty(example = "", value = "Indicacao do Aluno",required = true)
//	@NotEmpty(message = "campo obrigatório")
//	@Pattern(regexp = "")
//	private String indicacao;
	
//	@ApiModelProperty(example = "", value = "Ordem Indicacao do Aluno",required = true)
//	@NotEmpty(message = "campo obrigatório")
//	@Pattern(regexp = "")
//	private OrdemIndicacao ordemIndicacao;
	
	@ApiModelProperty(example= "00000111111",value="RA (matricula) do Aluno", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String ra;
	
	@ApiModelProperty(example= "111.111.11-11",value="Cpf do Aluno", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String cpf;
	
	@ApiModelProperty(example= "99.999.999",value="Rg do Aluno", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String rg;
	
	@ApiModelProperty(example = "UNICAP_IAM_TECH_SISTEMAS_PARA_INTERNET", value = "Escola/Curso do Aluno",required = true)
	@NotEmpty(message = "campo obrigatório")
	@Pattern(regexp = "CIENCIAS_JURIDICAS_DIREITO|COMUINCACAO_CURSO_SUPERIOR_DE_TECNOLOGIA_EM_FOTOGRAFIA|COMUINCACAO_JOGOS_DIGITAIS|COMUINCACAO_JORNALISMO|COMUINCACAO_PUBLICIDADE_E_PROPAGANDA|EDUCACAO_E_HUMANIDADES_CIENCIAS_BIOLOGICAS_LICENCIATURA|EDUCACAO_E_HUMANIDADES_CIENCIAS_DA_RELIGIAO_EAD|EDUCACAO_E_HUMANIDADES_FILOSOFIA_BACHARELADO|EDUCACAO_E_HUMANIDADES_FILOSOFIA_LICENCIATURA|EDUCACAO_E_HUMANIDADES_FISICA|EDUCACAO_E_HUMANIDADES_HISTORIA|EDUCACAO_E_HUMANIDADES_LETRAS_PORTUGUES_E_ESPANHOL|EDUCACAO_E_HUMANIDADES_LETRAS_PORTUGUES_E_INGLES|EDUCACAO_E_HUMANIDADES_MATEMATICA|EDUCACAO_E_HUMANIDADES_PEDAGOGIA|EDUCACAO_E_HUMANIDADES_QUIMICA|EDUCACAO_E_HUMANIDADES_SERVICO_SOCIAL|EDUCACAO_E_HUMANIDADES_TEOLOGIA|GESTAO_ECONOMIA_E_POLITICA_ADMINISTRACAO|GESTAO_ECONOMIA_E_POLITICA_CIENCIAS_CONTABEIS|GESTAO_ECONOMIA_E_POLITICA_CIENCIAS_ECONOMICAS|GESTAO_ECONOMIA_E_POLITICA_CIENCIA_POLITICA|SAUDE_E_CIENCIAS_DA_VIDA_CIENCIAS_BIOLOGICAS_BACHARELADO|SAUDE_E_CIENCIAS_DA_VIDA_ENFERMAGEM|SAUDE_E_CIENCIAS_DA_VIDA_FARMACIA|SAUDE_E_CIENCIAS_DA_VIDA_FISIOTERAPIA|SAUDE_E_CIENCIAS_DA_VIDA_FONOAUDIOLOGIA|SAUDE_E_CIENCIAS_DA_VIDA_MEDICINA|SAUDE_E_CIENCIAS_DA_VIDA_NUTRICAO|SAUDE_E_CIENCIAS_DA_VIDA_PSICOLOGIA|UNICAP_IAM_TECH_ARQUITETURA_E_URBANISMO|UNICAP_IAM_TECH_CIENCIA_DA_COMPUTACAO|UNICAP_IAM_TECH_ENGENHARIA_SOCIAL|UNICAP_IAM_TECH_ENGENHARIA_CIVIL|UNICAP_IAM_TECH_ENGENHARIA_DA_COMPLEXIDADE|UNICAP_IAM_TECH_ENGENHARIA_DE_PRODUCAO|UNICAP_IAM_TECH_ENGENHARIA_QUIMICA|UNICAP_IAM_TECH_SISTEMAS_PARA_INTERNET")
	private String curso;
	
	@ApiModelProperty(example= "maria.santos@instituicao.br",value="Email Institucional do Aluno", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String emailInstitucional;
	
	@ApiModelProperty(example= "(11) 11111-1111",value="Telefone para Contato do Aluno", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String contato;
	
	
	@ApiModelProperty(example= "1",value="Id Identificador do Plano de trabalho vinculado ao Aluno", required = true)
	@NotNull
    private Long planoDeTrabalhoId;

	

}
