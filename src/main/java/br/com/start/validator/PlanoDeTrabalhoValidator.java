package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.repository.PlanoDeTrabalhoRepository;

@Component
public class PlanoDeTrabalhoValidator {
	
	@Autowired
	private PlanoDeTrabalhoRepository repository;
	
	public void validarIdPlanoDeTrabalho(Long id) {
		if (!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.PLANO_DE_TRABALHO_NAO_ENCONTRADO);
		}
	}


}
