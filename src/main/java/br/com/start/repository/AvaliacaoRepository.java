package br.com.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Avaliacao;


public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

}
