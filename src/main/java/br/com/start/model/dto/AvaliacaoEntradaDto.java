package br.com.start.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
public class AvaliacaoEntradaDto {
	
	@ApiModelProperty(example = "1", value = "Id Identificador do Plano de Trabalho", required = true)
	@NotNull(message = "campo obrigatório")
	private Long planoDeTrabalhoId;
	
	@ApiModelProperty(example = "1", value = "Id Identificador do Avaliador", required = true)
	@NotNull(message = "campo obrigatório")
	private Long avaliadorId;
	
	@ApiModelProperty(example = "CIENCIA_EXTAS_E_DA_TERRA", value = "Area de conhecimento do Plano de Pesquisa", required = true)
	@NotNull
	@Pattern(regexp = "CIENCIA_EXTAS_E_DA_TERRA|CIENCIAS_BIOLOGICAS|ENGENHARIAS|CIENCIAS_DA_SAUDE|CIENCIAS_SOCIAIS_APLICADAS|CIENCIAS_HUMANAS|LINGUISTICA_LETRAS_E_ARTES")
	private String areaDeConhecimento;
	
	@ApiModelProperty(example = "VOLUNTARIO", value = "Area de conhecimento do Plano de Pesquisa", required = true)
	@NotNull
	@Pattern(regexp = "BOLSISTA_UNICAP|VOLUNTARIO|BOLSISTA_CNPQ")
	private String condicaoAluno;
	
	@ApiModelProperty(example = "DOUTORADO", value = "Adequacao do Plano de Trabalho do Professor",required = true)
	@NotEmpty(message = "campo obrigatório")
	@Pattern(regexp = "ADEQUADO|NAO_ADEQUADO")
	private String adequacao;
	
	@ApiModelProperty(example = "8.9", value = "Nota da Qualidade da Redacao", required = true)
	@NotNull(message = "campo obrigatório")
	private Double qualidadeRedacao;
	
	@ApiModelProperty(example = "8.9", value = "Nota do Conteudo Cientifico - Introdução", required = true)
	@NotNull(message = "campo obrigatório")
	private Double conteudoCientificoIntroducao;
	
	@ApiModelProperty(example = "8.9", value = "Nota do Conteudo Cientifico - Objetivos", required = true)
	@NotNull(message = "campo obrigatório")
	private Double conteudoCientificoObjetivos;
	
	@ApiModelProperty(example = "8.9", value = "Nota do Conteudo Cientifico - Material e Metodos", required = true)
	@NotNull(message = "campo obrigatório")
	private Double conteudoCientificoMaterialEMetodos;
	
	@ApiModelProperty(example = "8.9", value = "Nota do Conteudo Cientifico - Referencias", required = true)
	@NotNull(message = "campo obrigatório")
	private Double conteudoCientificoReferencias;	
	
	@ApiModelProperty(example = "9", value = "Numero de Paginas", required = true)
	@NotNull(message = "campo obrigatório")
	private int numeroPaginas;
	
	@ApiModelProperty(example = "Descricao do Parecer", value = "Decricao do parecer da Avaliacao", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String parecer;
	
	@ApiModelProperty(example = "RECOMENDADO", value = "Situacao do Aluno",required = true)
	@NotEmpty(message = "campo obrigatório")
	@Pattern(regexp = "RECOMENDADO|RECOMENDADO_COM_RESTRICAO|NAO_RECOMENDADO")
	private String situacaoAluno;
	
	@ApiModelProperty(example = "18/05/2014", value = "Data da resposta da Avaliacao", required = true)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataResposta;

}
