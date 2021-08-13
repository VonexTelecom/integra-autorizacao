package br.com.integra.api.security.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.integra.api.model.Usuario;
import br.com.integra.api.repository.UsuarioRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail informado"));
		
		//return new AuthUser(usuario, getAuthorities(usuario));
		return new AuthUser(usuario, null);
	}
	
//	private Collection<GrantedAuthority> getAuthorities(Usuario usuario) {
//		
//		return usuario.getGrupos().stream()
//				.flatMap(grupo -> grupo.getPermissoes().stream())
//				.map(permissao -> new SimpleGrantedAuthority(permissao.getNome().toUpperCase()))
//				.collect(Collectors.toSet());
//	}

}
