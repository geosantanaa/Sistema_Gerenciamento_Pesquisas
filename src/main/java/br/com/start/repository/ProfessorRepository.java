package br.com.start.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.start.model.Professor;


public interface ProfessorRepository extends JpaRepository<Professor, Long>{

	boolean existsByEmailInstitucional(String email);

}
