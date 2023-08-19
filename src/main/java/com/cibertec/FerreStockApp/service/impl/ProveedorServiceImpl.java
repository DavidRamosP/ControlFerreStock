package com.cibertec.FerreStockApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.FerreStockApp.model.Proveedor;
import com.cibertec.FerreStockApp.repository.ProveedorRepository;
import com.cibertec.FerreStockApp.service.ProveedorService;
@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return repository.findAll();
	}

	@Override
	public void agregarProveedor(Proveedor proveedor) {
		repository.save(proveedor);
	}

	@Override
	public Proveedor buscarProveedorPorId(int id) {
		return repository.findById(id).get();
	}


	@Override
	public void eliminarProveedor(int id) {
		repository.deleteById(id);
	}
	
}
