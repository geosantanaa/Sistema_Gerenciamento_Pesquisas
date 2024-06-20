package br.com.start.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.repository.AdminRepository;

@Component
public class AdminValidator {
	
	@Autowired
	private AdminRepository repository;
	
	public void validarIdAdmin(Long id) {
		if (!repository.existsById(id)) {
			throw new NegocioException(TabelaDeErros.ADMIN_NAO_ENCONTRADO);
		}
	}
	
	public void validarEmailAdmin(String email) {
		if (repository.existsByEmail(email)) {
			throw new NegocioException(TabelaDeErros.ADMIN_JA_CADASTRADO);
		}
	}


}
