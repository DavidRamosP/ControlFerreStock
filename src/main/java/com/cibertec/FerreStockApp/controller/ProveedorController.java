package com.cibertec.FerreStockApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.FerreStockApp.model.Proveedor;
import com.cibertec.FerreStockApp.service.impl.ProveedorServiceImpl;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorServiceImpl service;
	
	@GetMapping("/")
	public String obtenerProveedores(Model model) {
		model.addAttribute("proveedores", service.listarProveedores());
		return "proveedores";
	}
	
	
	@GetMapping("/newSupplier")
	public String nuevoProveedor(Model model) {
		Proveedor proveedor = new Proveedor();
		model.addAttribute("proveedor", proveedor);
		return "newSupplier";
	}
	
	@PostMapping("/saveSupplier")
	public String guardarTienda(@ModelAttribute("proveedor" )Proveedor proveedor){
		service.agregarProveedor(proveedor);
		return "redirect:/proveedor/";
	}
	
	@GetMapping("/updateSupplier/{id}")
	public String actualizarProveedor(@PathVariable(value = "id")int id, Model model) {
		Proveedor proveedor = service.buscarProveedorPorId(id);
		model.addAttribute("proveedor", proveedor);
		return "updateSupplier";
	}
	
	
	@GetMapping("/deleteSupplier/{id}")
	public String eliminarTienda(@PathVariable(value = "id")int id) {
		service.eliminarProveedor(id);
		return "redirect:/proveedor/";
	}
	
	
}


