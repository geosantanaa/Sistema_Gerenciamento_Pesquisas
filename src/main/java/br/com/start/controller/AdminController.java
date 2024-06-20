package br.com.start.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.model.dto.AdminEntradaDto;
import br.com.start.model.dto.AdminSaidaDto;
import br.com.start.repository.AdminRepository;
import br.com.start.service.AdminService;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("admin")
@Log4j2
@Validated
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@Autowired
	AdminRepository repository; 

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public AdminSaidaDto criar(@Valid @RequestBody AdminEntradaDto entrada) {
	//	log.info("Recebendo uma requisição: metodo = criar, entradaDto{}", entrada);
		return service.criar(entrada);
	}

	@PatchMapping("id/{id}/senha/{senha}")
	public void alterarSenha(@PathVariable("id") Long id, @PathVariable("senha") String senha) {
	//	log.info("alterar: {}", id);
		service.alterarSenha(id, senha);
	}

	@GetMapping("id/{id}")
	public AdminSaidaDto pegarUm(@PathVariable ("id") Long id) {
	//	log.info("PegarUm: {}", id);
		return service.pegarUm(id);
	}
	

	@DeleteMapping ("id/{id}")
	public void excluir(@PathVariable ("id") Long id) {
	//	log.info("excluir: {}", id);
		service.excluir(id);
	}

	@GetMapping 
	public List<AdminSaidaDto> listar() {
	//	log.info("listar");
		return service.listar();
	}
	

}
