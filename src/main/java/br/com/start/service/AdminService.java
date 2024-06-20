package br.com.start.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.start.exception.NegocioException;
import br.com.start.exception.TabelaDeErros;
import br.com.start.model.Admin;
import br.com.start.model.dto.AdminEntradaDto;
import br.com.start.model.dto.AdminSaidaDto;
import br.com.start.repository.AdminRepository;
import br.com.start.validator.AdminValidator;
import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class AdminService {
	
	@Autowired
	private AdminRepository repository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AdminValidator validator;

	public AdminSaidaDto criar(AdminEntradaDto entrada) {

		Admin entity = mapper.map(entrada, Admin.class);
		validator.validarEmailAdmin(entrada.getEmail());
		
		log.info("Processando uma requisição: metodo = criar, entity = {}", entity);

		Admin entityBanco = repository.save(entity);
		log.info("O banco de dados retornou: entityBanco = {}", entityBanco);


		return mapper.map(entityBanco, AdminSaidaDto.class);
	}


	public void alterarSenha(Long id, String senha) {		
		Optional<Admin> buscandoAdmin = repository.findById(id);
		if(!buscandoAdmin.isPresent()){
			throw new NegocioException(TabelaDeErros.ADMIN_NAO_ENCONTRADO);
		}

		Admin entityBanco = buscandoAdmin.get();
		entityBanco.setSenha(senha);
		repository.save(entityBanco);
		
	}

	public AdminSaidaDto pegarUm(Long id) {
		Optional<Admin> buscandoAdmin = repository.findById(id);
		if(!buscandoAdmin.isPresent()){
			throw new NegocioException(TabelaDeErros.ADMIN_NAO_ENCONTRADO);
		}
		Admin entityBanco = buscandoAdmin.get();
		log.info("O Banco de Dados retornou: entityBanco={}", entityBanco);
		return mapper.map(entityBanco, AdminSaidaDto.class);
	}

	public void excluir(Long id) {
		validator.validarIdAdmin(id);
		repository.deleteById(id);
	}

	public List<AdminSaidaDto> listar() {
		List<Admin> listaAdmins = repository.findAll();
		return mapper.map(listaAdmins, new TypeToken<List<AdminSaidaDto>>() {}.getType());
	}

}
