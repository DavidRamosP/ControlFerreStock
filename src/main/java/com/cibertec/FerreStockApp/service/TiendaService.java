package com.cibertec.FerreStockApp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cibertec.FerreStockApp.model.Tienda;

public interface TiendaService {

	
	public List<Tienda> obtenerTiendas();
	public void nuevaTienda(Tienda tienda);
	public Tienda buscarTienda(int id);
	public void eliminarTienda(int id);
	public Page<Tienda> buscarPagina(int page, int size);
}
