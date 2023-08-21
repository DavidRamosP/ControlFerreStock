package com.cibertec.FerreStockApp.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.ProductoTienda;
import com.cibertec.FerreStockApp.repository.ProductoTiendaRepository;
import com.cibertec.FerreStockApp.service.ProductoTiendaService;

@Service
public class ProductoTiendaServiceImpl implements ProductoTiendaService{

	@Autowired
	private ProductoTiendaRepository repository;
	
	@Override
	public List<ProductoTienda> listarProductosPorTiendaId(int id) {
		return repository.findByTiendaId(id);
	}

	@Override
	public void agregarProducto(ProductoTienda productoTienda) {
		repository.save(productoTienda);
		
	}

	@Override
	public void actualizarProducto(int id, ProductoTienda productoTienda) {
		ProductoTienda found = repository.findById(id).orElse(null);
		if(Objects.nonNull(found)) {
			found.setId(id);
			found.setStock(productoTienda.getStock());
		}
		repository.save(found);
	}

	@Override
	public void eliminarProductoTienda(int id) {
			repository.deleteById(id);
		
	}

	@Override
	public ProductoTienda buscarProductoTienda(int id) {
		return repository.findById(id).get();
	}

}
