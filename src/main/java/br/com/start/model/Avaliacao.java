package br.com.start.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter 
@Setter
@ToString
@Entity
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "avaliador_id")
	@JsonManagedReference
	private Professor avaliador;
	
	@OneToOne
	@JoinColumn(name = "plano_de_trabalho_id")
	@JsonManagedReference
	private PlanoDeTrabalho planoDeTrabalho;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "area_de_conhecimento", nullable = false, length = 300)
	private AreaDeConhecimento areaDeConhecimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "condicao_aluno", nullable = false, length = 200)
	private CondicaoAluno condicaoAluno;
		
	@Enumerated(EnumType.STRING)
	@Column(name = "adequacao", nullable = false, length = 30)
	private Adequacao adequacao;
	
	@Column(nullable = false, length = 200)
	private Double qualidadeRedacao;
	
	@Column(nullable = false, length = 200)
	private Double conteudoCientificoIntroducao;
	
	@Column(nullable = false, length = 200)
	private Double conteudoCientificoObjetivos;
	
	@Column(nullable = false, length = 200)
	private Double conteudoCientificoMaterialEMetodos;
	
	@Column(nullable = false, length = 200)
	private Double conteudoCientificoReferencias;
	
	@Column(nullable = false, length = 200)
	private int numeroPaginas;
	
	@Column(nullable = false, length = 500)
	private String parecer;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao_aluno", nullable = false, length = 30)
	private SituacaoDoAluno situacaoAluno;
	
	@Column(nullable = false, length = 200)
	private LocalDate dataResposta;
	

}
