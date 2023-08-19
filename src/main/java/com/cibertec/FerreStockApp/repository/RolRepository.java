package com.cibertec.FerreStockApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockApp.model.Rol;


@Repository
public interface RolRepository extends CrudRepository<Rol, Integer>{

	Rol findRolByName(String name);
}
