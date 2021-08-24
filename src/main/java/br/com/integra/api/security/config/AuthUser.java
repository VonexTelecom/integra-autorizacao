package br.com.integra.api.security.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.integra.api.model.Usuario;
import lombok.Getter;

@Getter
public class AuthUser extends User {

private static final long serialVersionUID = 1L;

	private String nome;
	private String usuario;
	private Long clienteId;
	
	public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> permissoes) {
		super(usuario.getEmail(), usuario.getSenha(), permissoes);
		
		this.nome = usuario.getNome();
		this.usuario = usuario.getUsuario();
		this.clienteId = usuario.getCliente().getId();
	}
	
}
