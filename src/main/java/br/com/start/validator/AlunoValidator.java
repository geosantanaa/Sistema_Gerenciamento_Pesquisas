package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.repository.AlunoRepository;

@Component
public class AlunoValidator {
	
	@Autowired
	private AlunoRepository repository;
	
	public void validarRaAluno(String ra) {
		if (repository.existsByRa(ra)) {
			throw new NegocioException(TabelaDeErros.ALUNO_JA_CADASTRADO);
		}
	}
	
	public void validarIdAluno(Long id) {
		if (!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
		}
	}

}
