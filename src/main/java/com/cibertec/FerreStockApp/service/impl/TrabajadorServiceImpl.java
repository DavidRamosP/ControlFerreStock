package com.cibertec.FerreStockApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.Trabajador;
import com.cibertec.FerreStockApp.repository.TrabajadorRepository;
import com.cibertec.FerreStockApp.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	@Autowired
	private TrabajadorRepository repository;
	
	@Override
	public void registrarTrabajador(Trabajador trabajador) {
		repository.save(trabajador);
	}

	@Override
	public Trabajador buscarTrabajadorPorDni(String dni) {
		return repository.findByDni(dni);
	}

	@Override
	public Trabajador buscarTrabajadorPorEmail(String email) {
		return repository.findByEmail(email);
	}

}
