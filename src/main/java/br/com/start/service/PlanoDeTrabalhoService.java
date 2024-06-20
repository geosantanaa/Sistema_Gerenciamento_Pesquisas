package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.Aluno;
import br.com.start.model.PlanoDeTrabalho;
import br.com.start.model.Professor;
import br.com.start.model.dto.PlanoDeTrabalhoEntradaDto;
import br.com.start.model.dto.PlanoDeTrabalhoSaidaDto;
import br.com.start.repository.AlunoRepository;
import br.com.start.repository.PlanoDeTrabalhoRepository;
import br.com.start.repository.ProfessorRepository;
import br.com.start.validator.PlanoDeTrabalhoValidator;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PlanoDeTrabalhoService {

	@Autowired
	private PlanoDeTrabalhoRepository PlanoDeTrabalhoRepository;

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PlanoDeTrabalhoValidator validator;

	public PlanoDeTrabalhoSaidaDto criar(PlanoDeTrabalhoEntradaDto entrada) {
	    PlanoDeTrabalho entity = mapper.map(entrada, PlanoDeTrabalho.class);

	    log.info("Processando uma requisição: metodo = criar, entity = {}", entity);

	    Optional<Professor> buscandoProfessor = professorRepository.findById(entrada.getProfessorId());
	    if (buscandoProfessor.isPresent()) {
	        Professor professor = buscandoProfessor.get();
	       System.out.println(professor.getId()); 
	        entity.setProfessor(professor);
	    }

	    List<Long> idsAlunos = entrada.getAlunosId();
	    List<Aluno> alunos = alunoRepository.findAllById(idsAlunos);

	    if (!alunos.isEmpty()) {
	        entity.setAlunos(alunos);
	    } else {
	        throw new NegocioException(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
	    }

	    PlanoDeTrabalho entityBanco = PlanoDeTrabalhoRepository.save(entity);
	    log.info("O banco de dados retornou: entityBanco = {}", entityBanco);

	    return mapper.map(entityBanco, PlanoDeTrabalhoSaidaDto.class);
	}


	
	public PlanoDeTrabalhoSaidaDto pegarUm(Long id) {
		Optional<PlanoDeTrabalho> buscandoPlanoDeTrabalho = PlanoDeTrabalhoRepository.findById(id);
		if (!buscandoPlanoDeTrabalho.isPresent()) {
			throw new NegocioException(TabelaDeErros.PLANO_DE_TRABALHO_NAO_ENCONTRADO);
		}
		PlanoDeTrabalho entityBanco = buscandoPlanoDeTrabalho.get();
		log.info("O Banco de Dados retornou: entityBanco={}", entityBanco);
		return mapper.map(entityBanco, PlanoDeTrabalhoSaidaDto.class);
	}

	public void excluir(Long id) {
		validator.validarIdPlanoDeTrabalho(id);
		PlanoDeTrabalhoRepository.deleteById(id);
	}

	public List<PlanoDeTrabalhoSaidaDto> listar() {
		List<PlanoDeTrabalho> listaPlanoDeTrabalhos = PlanoDeTrabalhoRepository.findAll();
		return mapper.map(listaPlanoDeTrabalhos, new TypeToken<List<PlanoDeTrabalhoSaidaDto>>() {
		}.getType());
	}

}
