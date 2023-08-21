package com.cibertec.FerreStockApp.service;

import java.util.List;

import com.cibertec.FerreStockApp.model.TipoUnidad;

public interface TipoUnidadService {

	List<TipoUnidad> listarUnidades();
	void agregarUnidades(TipoUnidad tipoUnidad);
}

