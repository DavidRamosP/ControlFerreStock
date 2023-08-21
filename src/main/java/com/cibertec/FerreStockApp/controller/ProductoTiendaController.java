package com.cibertec.FerreStockApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cibertec.FerreStockApp.model.ProductoTienda;
import com.cibertec.FerreStockApp.service.impl.ProductoServiceImpl;
import com.cibertec.FerreStockApp.service.impl.ProductoTiendaServiceImpl;
import com.cibertec.FerreStockApp.service.impl.TiendaServiceImpl;


@Controller
public class ProductoTiendaController {

	@Autowired
	private ProductoTiendaServiceImpl serviceProductoTienda;
	
	@Autowired
	private TiendaServiceImpl serviceTienda;
	
	@Autowired
	private ProductoServiceImpl serviceProducto;

	@GetMapping("/productosTienda/{id}")
	public String listaProductosTienda(@PathVariable(name = "id")int id, Model model) {
		model.addAttribute("tiendaElegida", serviceTienda.buscarTienda(id));
		List<ProductoTienda> lista = serviceProductoTienda.listarProductosPorTiendaId(id);
		model.addAttribute("productosTienda", lista);
		return "productosTienda";
	}
	
	
	@GetMapping("/productoTienda")
	public String registrarProducto(Model model, @ModelAttribute("producto")ProductoTienda productoTienda) {
		ProductoTienda nuevo = new ProductoTienda();
		nuevo.setTienda(productoTienda.getTienda());
		model.addAttribute("tiendas", serviceTienda.obtenerTiendas());
		model.addAttribute("productos", serviceProducto.obtenerProductos());
		model.addAttribute("productoTienda", nuevo);
		return "newProductoTienda";
	}
	
	@PostMapping("/productoTienda")
	public String guardarProducto(@ModelAttribute("productoTienda")ProductoTienda productoTienda) {
		serviceProductoTienda.agregarProducto(productoTienda);
		return "redirect:/productosTienda/"+productoTienda.getTienda().getId();	
	}
	
	@GetMapping("/actualizarProductoTienda/{id}")
	public String actualizarProducto(@PathVariable int id, Model model) {
		ProductoTienda found = serviceProductoTienda.buscarProductoTienda(id);
		model.addAttribute("tiendas", serviceTienda.obtenerTiendas());
		model.addAttribute("productos", serviceProducto.obtenerProductos());
		model.addAttribute("productoTienda", found);
		return "/updateProductoTienda";
	}
	
	@GetMapping("/eliminarProductoTienda/{id}")
	public String eliminarProducto(@PathVariable int id) {
		ProductoTienda found = serviceProductoTienda.buscarProductoTienda(id);
		serviceProductoTienda.eliminarProductoTienda(id);
		return "redirect:/productosTienda/"+found.getTienda().getId();	
	}
	
	
}
