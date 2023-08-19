package com.cibertec.FerreStockApp.service;

import com.cibertec.FerreStockApp.model.Usuario;

public interface UsuarioService {

	Usuario buscarUsuario(String username);
	void agregarUsuario(Usuario usuario);
}
