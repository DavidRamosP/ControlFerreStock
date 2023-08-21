package com.cibertec.FerreStockApp.service;

import com.cibertec.FerreStockApp.model.Trabajador;

public interface TrabajadorService {

	void registrarTrabajador(Trabajador trabajador);
	Trabajador buscarTrabajadorPorDni(String dni);
	Trabajador buscarTrabajadorPorEmail(String email);
}
