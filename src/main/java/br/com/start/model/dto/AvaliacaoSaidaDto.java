package br.com.start.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.start.model.Adequacao;
import br.com.start.model.AreaDeConhecimento;
import br.com.start.model.CondicaoAluno;
import br.com.start.model.PlanoDeTrabalho;
import br.com.start.model.Professor;
import br.com.start.model.SituacaoDoAluno;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvaliacaoSaidaDto {

	private Long id;
	private PlanoDeTrabalho planoDeTrabalho;
	private Professor avaliador;
	private AreaDeConhecimento areaDeConhecimento;
	private CondicaoAluno condicaoAluno;
	private Adequacao adequacao;
	private Double qualidadeRedacao;
	private Double conteudoCientificoIntroducao;
	private Double conteudoCientificoObjetivos;
	private Double conteudoCientificoMaterialEMetodos;
	private Double conteudoCientificoReferencias;
	private int numeroPaginas;
	private String parecer;
	private SituacaoDoAluno situacaoAluno;
	private LocalDate dataResposta;

}
