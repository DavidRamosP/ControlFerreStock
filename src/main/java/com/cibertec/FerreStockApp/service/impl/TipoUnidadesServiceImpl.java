package com.cibertec.FerreStockApp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.TipoUnidad;
import com.cibertec.FerreStockApp.repository.TipoUnidadRepository;
import com.cibertec.FerreStockApp.service.TipoUnidadService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoUnidadesServiceImpl implements TipoUnidadService {

	private TipoUnidadRepository repository;
	
	@Override
	public List<TipoUnidad> listarUnidades() {
		return repository.findAll();
	}

}
