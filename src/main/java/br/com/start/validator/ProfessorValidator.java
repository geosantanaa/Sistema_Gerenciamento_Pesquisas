package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.repository.ProfessorRepository;

@Component
public class ProfessorValidator {
	
	@Autowired
	private ProfessorRepository repository;

	public void validarEmailProfessor(String email) {
		if (repository.existsByEmailInstitucional(email)) {
			throw new NegocioException(TabelaDeErros.PROFESSOR_JA_CADASTRADO);
		}
	}
	
	public void validarIdProfessor(Long id) {
		if (!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.PROFESSOR_NAO_ENCONTRADO);
		}
	}

}
