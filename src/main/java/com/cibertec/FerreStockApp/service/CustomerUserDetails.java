package com.cibertec.FerreStockApp.service;


import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cibertec.FerreStockApp.model.Usuario;

@Service
public class CustomerUserDetails implements UserDetailsService {

	@Autowired
	private UsuarioService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = service.buscarUsuario(username);
	
		if(usuario!=null) {
			User user = new User(usuario.getUsername()
							, usuario.getPassword()
							, usuario.getRoles().stream()
							.map(rol -> new SimpleGrantedAuthority(rol.getName()))
							.collect(Collectors.toList())
					);
			System.out.println(user.toString());
			return user;
		
		}else {
			throw  new UsernameNotFoundException("Usuario incorrecto o no registrado");
		}
		
		
	}

}
