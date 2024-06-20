package br.com.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	boolean existsByRa(String ra);

}
