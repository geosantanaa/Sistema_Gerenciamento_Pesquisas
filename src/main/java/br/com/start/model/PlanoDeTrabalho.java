package br.com.start.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class PlanoDeTrabalho {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_pesquisa", nullable = false, length = 300)
    private String tituloPesquisa;

    @Column(name = "numero_projeto", nullable = false, length = 300)
    private String numeroProjeto;

    @Column(name = "area_de_conhecimento", nullable = false, length = 300)
    private AreaDeConhecimento areaDeConhecimento;

    @Column(name = "nome_grupo_pesquisa", nullable = false, length = 300)
    private String nomeGrupoPesquisa;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonBackReference
    private Professor professor;

    @OneToMany(mappedBy = "planoDeTrabalho")
    @JsonManagedReference
    private List<Aluno> alunos;

}
