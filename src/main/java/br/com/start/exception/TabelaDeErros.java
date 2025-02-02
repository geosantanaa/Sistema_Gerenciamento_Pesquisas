package br.com.start.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TabelaDeErros {
	
	VALIDACAO (HttpStatus.BAD_REQUEST ,"1000 - 1000", "DADOS DE REQUISIÇÃO INVÁLIDOS, TENTE NOVAMENTE"),
		
	SISTEMA(HttpStatus.INTERNAL_SERVER_ERROR,"1000 - 5000", "SISTEMA INDISPONÍVEL, TENTE MAIS TARDE"),

	ADMIN_NAO_ENCONTRADO (HttpStatus.NOT_FOUND,"1000 - 3001", "INFORMAÇÕES INVÁLIDAS, ADMIN NÃO ENCONTRADO"),
	ADMIN_JA_CADASTRADO (HttpStatus.NOT_FOUND,"1000 - 3001", "OPS! EMAIL DO ADMIN JÁ CADASTRADO"),

	ENDERECO_NAO_ENCONTRADO (HttpStatus.NOT_FOUND,"1000 - 3001", "INFORMAÇÕES INVÁLIDAS, ENDERECO NÃO ENCONTRADO"),

	ALUNO_NAO_ENCONTRADO (HttpStatus.NOT_FOUND,"1000 - 3001", "INFORMAÇÕES INVÁLIDAS, ALUNO NÃO ENCONTRADO"),
	ALUNO_JA_CADASTRADO (HttpStatus.CONFLICT ,"1000 - 4009", "O RA DO ALUNO JÁ CONSTA NA BASE DE DADOS"),

	AVALIACAO_NAO_ENCONTRADA (HttpStatus.NOT_FOUND,"1000 - 3001", "INFORMAÇÕES INVÁLIDAS, AVALIAÇÃO NÃO ENCONTRADA"),

	PROFESSOR_JA_CADASTRADO (HttpStatus.CONFLICT ,"1000 - 4009", "O EMAIL DO PROFESSOR JÁ CONSTA NA BASE DE DADOS"),
	PROFESSOR_NAO_ENCONTRADO (HttpStatus.NOT_FOUND,"1000 - 3001", "INFORMAÇÕES INVÁLIDAS, PROFESSOR NÃO ENCONTRADO"),

	PLANO_DE_TRABALHO_NAO_ENCONTRADO (HttpStatus.NOT_FOUND,"1000 - 3001", "INFORMAÇÕES INVÁLIDAS, PROFESSOR NÃO ENCONTRADO");

	private final HttpStatus codigoHttp;
	private final String codigoErro;
	private final String mensagem;
	

}
