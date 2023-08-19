package com.cibertec.FerreStockApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.Producto;
import com.cibertec.FerreStockApp.repository.ProductoRepository;
import com.cibertec.FerreStockApp.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<Producto> obtenerProductos() {
		return repository.findAll();
	}

	@Override
	public void nuevoProducto(Producto producto) {
		repository.save(producto);
	}

	@Override
	public Producto buscarProducto(int id) {
		Producto found = repository.findById(id).orElse(null);		
		return found;
	}

	@Override
	public void eliminarProducto(int id) {
		repository.deleteById(id);
		
	}

	@Override
	public Page<Producto> buscarProducto(int page, int size) {
		Pageable pageable = PageRequest.of(page-1, size);
		Page<Producto> pagina = repository.findAll(pageable);
		
		return pagina;
	}

}
