package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.repository.AvaliacaoRepository;

@Component
public class AvaliacaoValidator {
	
	@Autowired
	private AvaliacaoRepository repository;
	
	public void validarIdAvaliacao(Long id) {
		if (!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.AVALIACAO_NAO_ENCONTRADA);
		}
	}

}
