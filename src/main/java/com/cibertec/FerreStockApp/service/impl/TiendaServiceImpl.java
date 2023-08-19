package com.cibertec.FerreStockApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.Tienda;
import com.cibertec.FerreStockApp.repository.TiendaRepository;
import com.cibertec.FerreStockApp.service.TiendaService;


@Service
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private TiendaRepository repository;
	
	@Override
	public List<Tienda> obtenerTiendas(){
		List<Tienda> listado = new ArrayList<Tienda>();
		repository.findAll().forEach(tienda -> {listado.add(tienda);});
		return listado;
	}
	@Override
	public void nuevaTienda(Tienda tienda) {
		repository.save(tienda);
	}
	
	@Override
	public Tienda buscarTienda(int id) {
		Tienda tiendaEncontrada = repository.findById(id).get();
		return tiendaEncontrada;
	}
	
	@Override
	public void eliminarTienda(int id) {
		repository.deleteById(id);
	}
	
	@Override
	public Page<Tienda> buscarPagina(int page, int size){
		Pageable pageable = PageRequest.of(page-1, size);
		Page<Tienda> pagina = repository.findAll(pageable);
		return pagina;		
	}
}