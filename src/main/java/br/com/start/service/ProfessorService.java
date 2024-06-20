package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.Professor;
import br.com.start.model.dto.ProfessorEntradaDto;
import br.com.start.model.dto.ProfessorSaidaDto;
import br.com.start.repository.ProfessorRepository;
import br.com.start.validator.ProfessorValidator;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProfessorValidator validator;

	public ProfessorSaidaDto criar(ProfessorEntradaDto entrada) {

		Professor entity = mapper.map(entrada, Professor.class);
		validator.validarEmailProfessor(entrada.getEmailInstitucional());
		
		log.info("Processando uma requisição: metodo = criar, entity = {}", entity);

		Professor entityBanco = repository.save(entity);
		log.info("O banco de dados retornou: entityBanco = {}", entityBanco);


		return mapper.map(entityBanco, ProfessorSaidaDto.class);
	}
	
	public void alterarSenha(Long id, String senha) {		
		Optional<Professor> buscandoProfessor = repository.findById(id);
		if(!buscandoProfessor.isPresent()){
			throw new NegocioException(TabelaDeErros.PROFESSOR_NAO_ENCONTRADO);
		}

		Professor entityBanco = buscandoProfessor.get();
		entityBanco.setSenha(senha);
		repository.save(entityBanco);
		
	}

	public ProfessorSaidaDto pegarUm(Long id) {
		Optional<Professor> buscandoProfessor = repository.findById(id);
		if (!buscandoProfessor.isPresent()) {
			throw new NegocioException(TabelaDeErros.PROFESSOR_NAO_ENCONTRADO);
		}
		Professor entityBanco = buscandoProfessor.get();
		log.info("O Banco de Dados retornou: entityBanco={}", entityBanco);
		return mapper.map(entityBanco, ProfessorSaidaDto.class);
	}

	public void excluir(Long id) {
		validator.validarIdProfessor(id);
		repository.deleteById(id);
	}

	public List<ProfessorSaidaDto> listar() {
		List<Professor> listaProfessores = repository.findAll();
		return mapper.map(listaProfessores, new TypeToken<List<ProfessorSaidaDto>>() {
		}.getType());
	}

}
