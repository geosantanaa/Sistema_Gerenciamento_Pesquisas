package br.com.start.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.Avaliacao;
import br.com.start.model.PlanoDeTrabalho;
import br.com.start.model.Professor;
import br.com.start.model.dto.AvaliacaoEntradaDto;
import br.com.start.model.dto.AvaliacaoSaidaDto;
import br.com.start.repository.AvaliacaoRepository;
import br.com.start.repository.PlanoDeTrabalhoRepository;
import br.com.start.repository.ProfessorRepository;
import br.com.start.validator.AvaliacaoValidator;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository AvaliacaoRepository;
	
	@Autowired
	private PlanoDeTrabalhoRepository planoDeTrabalhoRepository;

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AvaliacaoValidator validator;
	

	public AvaliacaoSaidaDto criar(AvaliacaoEntradaDto entrada) {

		Avaliacao entity = mapper.map(entrada, Avaliacao.class);
		
		if (entrada.getDataResposta() == null) {
			entity.setDataResposta(LocalDate.now());
		}

		log.info("Processando uma requisição: metodo = criar, entity = {}", entity);
		
		Avaliacao entityBanco = AvaliacaoRepository.save(entity);
		
		log.info("O banco de dados retornou: entityBanco = {}", entityBanco);
	    
	    Optional<PlanoDeTrabalho> buscandoPlanoDeTrabalho = planoDeTrabalhoRepository.findById(entrada.getPlanoDeTrabalhoId());
	    if (buscandoPlanoDeTrabalho.isPresent()) {
	    	PlanoDeTrabalho planoDeTrabalho = buscandoPlanoDeTrabalho.get();
	        entity.setPlanoDeTrabalho(planoDeTrabalho);
	    }
	    
	    Optional<Professor> buscandoProfessor = professorRepository.findById(entrada.getAvaliadorId());
	    if (buscandoProfessor.isPresent()) {
	    	Professor avaliador = buscandoProfessor.get();
	        entity.setAvaliador(avaliador);
	    }


		return mapper.map(entityBanco, AvaliacaoSaidaDto.class);
	}
	
	public AvaliacaoSaidaDto pegarUm(Long id) {
		Optional<Avaliacao> buscandoAvaliacao = AvaliacaoRepository.findById(id);
		if (!buscandoAvaliacao.isPresent()) {
			throw new NegocioException(TabelaDeErros.AVALIACAO_NAO_ENCONTRADA);
		}
		Avaliacao entityBanco = buscandoAvaliacao.get();
		log.info("O Banco de Dados retornou: entityBanco={}", entityBanco);
		return mapper.map(entityBanco, AvaliacaoSaidaDto.class);
	}

	public void excluir(Long id) {
		validator.validarIdAvaliacao(id);
		AvaliacaoRepository.deleteById(id);
	}

	public List<AvaliacaoSaidaDto> listar() {
		List<Avaliacao> listaAvaliacoes = AvaliacaoRepository.findAll();
		return mapper.map(listaAvaliacoes, new TypeToken<List<AvaliacaoSaidaDto>>() {
		}.getType());
	}

}
