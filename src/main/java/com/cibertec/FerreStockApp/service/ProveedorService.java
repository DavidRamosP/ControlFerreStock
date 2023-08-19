package com.cibertec.FerreStockApp.service;

import java.util.List;

import com.cibertec.FerreStockApp.model.Proveedor;

public interface ProveedorService {

	List<Proveedor> listarProveedores();
	void agregarProveedor(Proveedor proveedor);
	Proveedor buscarProveedorPorId(int id);
	void eliminarProveedor(int id);
}
