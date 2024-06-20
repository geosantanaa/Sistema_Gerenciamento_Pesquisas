package br.com.start.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel
@Getter
@Setter
@ToString
public class AdminEntradaDto {
	
	@ApiModelProperty(example= "Fernanda",value="Nome do Admin", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String nome;
	
	@ApiModelProperty(example= "fernanda@email.com",value="E-mail do Admin", required = true)
	@Email(message = "formato de email inválido")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String email;
	
	@ApiModelProperty(example= "123abc",value="Senha do Admin", required = true)
	@NotEmpty(message = "campo obrigatório")
	@Size( max=200, message="máximo permitido é 200 caracters")
	private String senha;


}
