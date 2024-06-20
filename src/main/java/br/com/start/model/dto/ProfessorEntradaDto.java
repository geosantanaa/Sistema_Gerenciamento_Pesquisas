package br.com.start.model.dto;

import java.util.List;

import javax.validation.constraints.Email;
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
public class ProfessorEntradaDto {

	@ApiModelProperty(example= "Luis",value="Nome do Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String nome;
	
	@ApiModelProperty(example= "luis@instituicao.br",value="E-mail do Professor", required = true)
	@Email(message = "formato de email inválido")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String emailInstitucional;
	
	@ApiModelProperty(example= "123abc",value="Senha do Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String senha;
	
	@ApiModelProperty(example = "DOUTORADO", value = "Nivel do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Pattern(regexp = "MESTRADO|DOUTORADO")
	private String nivelOrientador;
	
	@ApiModelProperty(example = "00000123456", value = "Matricula do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size(max = 200, message = "máximo permitido é 200 caracters")
	private String matricula;
	
	@ApiModelProperty(example= "CIENCIAS_JURIDICAS_DIREITO",value="Escola/Curso do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Pattern(regexp = "CIENCIAS_JURIDICAS_DIREITO|COMUINCACAO_CURSO_SUPERIOR_DE_TECNOLOGIA_EM_FOTOGRAFIA|COMUINCACAO_JOGOS_DIGITAIS|COMUINCACAO_JORNALISMO|COMUINCACAO_PUBLICIDADE_E_PROPAGANDA|EDUCACAO_E_HUMANIDADES_CIENCIAS_BIOLOGICAS_LICENCIATURA|EDUCACAO_E_HUMANIDADES_CIENCIAS_DA_RELIGIAO_EAD|EDUCACAO_E_HUMANIDADES_FILOSOFIA_BACHARELADO|EDUCACAO_E_HUMANIDADES_FILOSOFIA_LICENCIATURA|EDUCACAO_E_HUMANIDADES_FISICA|EDUCACAO_E_HUMANIDADES_HISTORIA|EDUCACAO_E_HUMANIDADES_LETRAS_PORTUGUES_E_ESPANHOL|EDUCACAO_E_HUMANIDADES_LETRAS_PORTUGUES_E_INGLES|EDUCACAO_E_HUMANIDADES_MATEMATICA|EDUCACAO_E_HUMANIDADES_PEDAGOGIA|EDUCACAO_E_HUMANIDADES_QUIMICA|EDUCACAO_E_HUMANIDADES_SERVICO_SOCIAL|EDUCACAO_E_HUMANIDADES_TEOLOGIA|GESTAO_ECONOMIA_E_POLITICA_ADMINISTRACAO|GESTAO_ECONOMIA_E_POLITICA_CIENCIAS_CONTABEIS|GESTAO_ECONOMIA_E_POLITICA_CIENCIAS_ECONOMICAS|GESTAO_ECONOMIA_E_POLITICA_CIENCIA_POLITICA|SAUDE_E_CIENCIAS_DA_VIDA_CIENCIAS_BIOLOGICAS_BACHARELADO|SAUDE_E_CIENCIAS_DA_VIDA_ENFERMAGEM|SAUDE_E_CIENCIAS_DA_VIDA_FARMACIA|SAUDE_E_CIENCIAS_DA_VIDA_FISIOTERAPIA|SAUDE_E_CIENCIAS_DA_VIDA_FONOAUDIOLOGIA|SAUDE_E_CIENCIAS_DA_VIDA_MEDICINA|SAUDE_E_CIENCIAS_DA_VIDA_NUTRICAO|SAUDE_E_CIENCIAS_DA_VIDA_PSICOLOGIA|UNICAP_IAM_TECH_ARQUITETURA_E_URBANISMO|UNICAP_IAM_TECH_CIENCIA_DA_COMPUTACAO|UNICAP_IAM_TECH_ENGENHARIA_SOCIAL|UNICAP_IAM_TECH_ENGENHARIA_CIVIL|UNICAP_IAM_TECH_ENGENHARIA_DA_COMPLEXIDADE|UNICAP_IAM_TECH_ENGENHARIA_DE_PRODUCAO|UNICAP_IAM_TECH_ENGENHARIA_QUIMICA|UNICAP_IAM_TECH_SISTEMAS_PARA_INTERNET")
	private String curso;
	
	@ApiModelProperty(example = "111.111.111-11", value = "Cpf do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size(max = 200, message = "máximo permitido é 200 caracters")
	private String cpf;
	
	@ApiModelProperty(example = "(11) 11111-1111", value = "Telefone do Orientador/Professor", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size(max = 200, message = "máximo permitido é 200 caracters")
	private String contatoOrientador;
	
	@ApiModelProperty(example = "[1,2]", value = "Ids Identificadores do(s) plano(s) detrabalhos(s) do Orientador/Professor", required = true)
	@NotNull
	private List <Long> planoDeTrabalhoId;

}
