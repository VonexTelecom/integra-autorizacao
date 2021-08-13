package br.com.integra.api.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UsuarioFilter")
public class UsuarioFilter {
	
	@ApiModelProperty(value = "ID do usuario", dataType = "Integer", example = "83")
	private Integer clientId;
	
	@ApiModelProperty(value = "Nome do usuario", dataType = "String", example = "Usuario1")
	private String nome;
}
