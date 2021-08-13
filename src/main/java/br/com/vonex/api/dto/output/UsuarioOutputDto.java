package br.com.vonex.api.dto.output;

import java.util.Date;

import br.com.vonex.api.enums.UsuarioTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDto {
	
	private String nome;

	private String email;
	
	private String usuario;
	
	private String senha;
	
	private UsuarioTipo tipo;
	
	private Integer ativo;
	
	private Date dataDeCriacao;
	
	//private Integer clientId;
}
