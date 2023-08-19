package com.cibertec.FerreStockApp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cibertec.FerreStockApp.model.Producto;


public interface ProductoService {

	public List<Producto> obtenerProductos();
	public void nuevoProducto(Producto producto);
	public Producto buscarProducto(int id);
	public void eliminarProducto(int id);
	public Page<Producto> buscarProducto(int page, int size);
	
}
