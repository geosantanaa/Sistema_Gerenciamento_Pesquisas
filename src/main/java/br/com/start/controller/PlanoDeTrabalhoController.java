package br.com.start.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.model.dto.PlanoDeTrabalhoEntradaDto;
import br.com.start.model.dto.PlanoDeTrabalhoSaidaDto;
import br.com.start.repository.PlanoDeTrabalhoRepository;
import br.com.start.service.PlanoDeTrabalhoService;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("planoDeTrabalho")
@Log4j2
@Validated
public class PlanoDeTrabalhoController {
	
	@Autowired
	PlanoDeTrabalhoService service;
	
	@Autowired
	PlanoDeTrabalhoRepository repository; 

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public PlanoDeTrabalhoSaidaDto criar(@Valid @RequestBody PlanoDeTrabalhoEntradaDto entrada) {
		log.info("Recebendo uma requisição: metodo = criar, entradaDto{}", entrada);
		return service.criar(entrada);
	}

	@GetMapping("id/{id}")
	public PlanoDeTrabalhoSaidaDto pegarUm(@PathVariable ("id") Long id) {
		log.info("PegarUm: {}", id);
		return service.pegarUm(id);
	}
	

	@DeleteMapping ("id/{id}")
	public void excluir(@PathVariable ("id") Long id) {
		log.info("excluir: {}", id);
		service.excluir(id);
	}

	@GetMapping 
	public List<PlanoDeTrabalhoSaidaDto> listar() {
		log.info("listar");
		return service.listar();
	}
	

}
