package com.cibertec.FerreStockApp.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.FerreStockApp.model.Producto;
import com.cibertec.FerreStockApp.service.impl.ProductoServiceImpl;
import com.cibertec.FerreStockApp.service.impl.ProveedorServiceImpl;
import com.cibertec.FerreStockApp.service.impl.TipoUnidadesServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoController {


	private ProductoServiceImpl service;
	private ProveedorServiceImpl serviceProveedor;
	private TipoUnidadesServiceImpl serviceTipos;
	
	@GetMapping("/")
	public String obtenerProductos(Model model) {
		return buscarPagina(model, 1);
	}
	
	@GetMapping("/page/{page}")
	public String buscarPagina(Model model,@PathVariable("page") int page) {
		int size = 2;
		Page<Producto> pagina = service.buscarProducto(page, size);
		List<Producto> productos = pagina.getContent();
		model.addAttribute("productos", productos);
		model.addAttribute("paginasTotalesPro", pagina.getTotalPages());
		model.addAttribute("paginaActualPro", page);
		model.addAttribute("cantidadElementosPro", pagina.getTotalElements());
		
		return "productos";
	}
	@GetMapping("/newProduct")
	public String nuevoProducto(Model model) {
		Producto nuevoProducto = new Producto();
		model.addAttribute("proveedores", serviceProveedor.listarProveedores());
		model.addAttribute("tipos", serviceTipos.listarUnidades());
		model.addAttribute("producto", nuevoProducto);
		return "newProduct";
	}
	
	@PostMapping("/saveProduct")
	public String guardarProducto(@ModelAttribute("producto" )Producto producto, Model model){	
		service.nuevoProducto(producto);
		return "redirect:/productos/";
	}
	
	@GetMapping("/updateProduct/{id}")
	public String actualizarProducto(@PathVariable(value = "id")int id, Model model) {
		Producto productoEncontrado = service.buscarProducto(id);
		model.addAttribute("proveedores", serviceProveedor.listarProveedores());
		model.addAttribute("tipos", serviceTipos.listarUnidades());
		model.addAttribute("producto", productoEncontrado);
		return "updateProduct";
	}
	
	
	@GetMapping("/deleteProduct/{id}")
	public String eliminarTienda(@PathVariable(value = "id")int id) {
		service.eliminarProducto(id);
		return "redirect:/productos/";
	}
	
}
