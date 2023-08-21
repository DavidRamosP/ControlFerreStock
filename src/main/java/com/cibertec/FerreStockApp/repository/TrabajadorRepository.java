package com.cibertec.FerreStockApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.FerreStockApp.model.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
	Trabajador findByDni(String dni);
	Trabajador findByEmail(String email);
}
