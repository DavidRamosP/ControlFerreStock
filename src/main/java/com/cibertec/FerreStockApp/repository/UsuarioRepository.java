package com.cibertec.FerreStockApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockApp.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	Usuario findUsuarioByUsername(String username);
}
