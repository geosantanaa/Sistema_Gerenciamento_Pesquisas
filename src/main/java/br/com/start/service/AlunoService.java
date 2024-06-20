package br.com.start.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.Aluno;
import br.com.start.model.Curso;
import br.com.start.model.dto.AlunoEntradaDto;
import br.com.start.model.dto.AlunoSaidaDto;
import br.com.start.repository.AlunoRepository;
import br.com.start.validator.AlunoValidator;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AlunoValidator validator;

	public AlunoSaidaDto criar(AlunoEntradaDto entrada) {

		Aluno entity = mapper.map(entrada, Aluno.class);
		validator.validarRaAluno(entrada.getRa());

		log.info("Processando uma requisição: metodo = criar, entity = {}", entity);

		Aluno entityBanco = alunoRepository.save(entity);
		log.info("O banco de dados retornou: entityBanco = {}", entityBanco);
		
	    
	  	return mapper.map(entityBanco, AlunoSaidaDto.class);
	}
	
	@Transactional
	public void alterar(Long id, AlunoEntradaDto entrada) {
			Optional<Aluno> optional = alunoRepository.findById(id);

			if (!optional.isPresent()) {
				throw new NegocioException(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
			}

			Aluno alunoDB = optional.get();
			alunoDB.setNome(entrada.getNome());
            alunoDB.setCurso(Curso.valueOf(entrada.getCurso()));
			alunoDB.setContato(entrada.getContato());
			
			alunoRepository.save(alunoDB);
	}

	public AlunoSaidaDto pegarUm(Long id) {
		Optional<Aluno> buscandoAluno = alunoRepository.findById(id);
		if (!buscandoAluno.isPresent()) {
			throw new NegocioException(TabelaDeErros.ALUNO_NAO_ENCONTRADO);
		}
		Aluno entityBanco = buscandoAluno.get();
		log.info("O Banco de Dados retornou: entityBanco={}", entityBanco);
		return mapper.map(entityBanco, AlunoSaidaDto.class);
	}

	public void excluir(Long id) {
		validator.validarIdAluno(id);
		alunoRepository.deleteById(id);
	}

	public List<AlunoSaidaDto> listar() {
		List<Aluno> listaAlunos = alunoRepository.findAll();
		return mapper.map(listaAlunos, new TypeToken<List<AlunoSaidaDto>>() {
		}.getType());
	}

}
