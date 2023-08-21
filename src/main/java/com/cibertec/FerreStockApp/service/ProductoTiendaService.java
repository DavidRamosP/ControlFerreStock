package com.cibertec.FerreStockApp.service;

import java.util.List;

import com.cibertec.FerreStockApp.model.ProductoTienda;

public interface ProductoTiendaService {

	List<ProductoTienda> listarProductosPorTiendaId(int id);
	void agregarProducto(ProductoTienda productoTienda);
	void actualizarProducto(int id, ProductoTienda productoTienda);
	void eliminarProductoTienda(int id);
	ProductoTienda buscarProductoTienda(int id);
}

