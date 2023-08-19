package com.cibertec.FerreStockApp.service.impl;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.Rol;
import com.cibertec.FerreStockApp.model.Usuario;
import com.cibertec.FerreStockApp.repository.RolRepository;
import com.cibertec.FerreStockApp.repository.UsuarioRepository;
import com.cibertec.FerreStockApp.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Usuario buscarUsuario(String username) {
		Usuario found = usuarioRepository.findUsuarioByUsername(username);
		return found;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		
		Rol rol = rolRepository.findRolByName("ROLE_USER");
		
		if(Objects.isNull(rol)) {
			rol = new Rol("ROLE_USER");
			rolRepository.save(rol);
		}
		
		Usuario usuarioNuevo = new Usuario(usuario.getUsername(),
									passwordEncoder.encode(usuario.getPassword()),
									1, 1
									, Arrays.asList(rol));
		
		
		usuarioRepository.save(usuarioNuevo);
	}

}
