package com.cibertec.FerreStockApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cibertec.FerreStockApp.model.Tienda;
import com.cibertec.FerreStockApp.service.impl.TiendaServiceImpl;

@Controller
@RequestMapping("/tiendas")
public class TiendaController {

	@Autowired
	private TiendaServiceImpl service;
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	
	@GetMapping("/")
	public String obtenerTiendas(Model model) {
		return buscarPagina(model, 1);
	}
	
	@GetMapping("/page/{page}")
	public String buscarPagina(Model model,@PathVariable("page") int page) {
		int size = 2;
		Page<Tienda> pagina = service.buscarPagina(page, size);
		List<Tienda> tiendas = pagina.getContent();
		model.addAttribute("tiendas", tiendas);
		model.addAttribute("paginasTotales", pagina.getTotalPages());
		model.addAttribute("paginaActual", page);
		model.addAttribute("cantidadElementos", pagina.getTotalElements());
		
		return "tiendas";
	}
	@GetMapping("/newStore")
	public String nuevaTienda(Model model) {
		Tienda nuevaTienda = new Tienda();
		model.addAttribute("tienda", nuevaTienda);
		return "newStore";
	}
	
	@PostMapping("/saveStore")
	public String guardarTienda(@ModelAttribute("tienda" )Tienda tienda){
		service.nuevaTienda(tienda);
		return "redirect:/tiendas/";
	}
	
	@GetMapping("/updateStore/{id}")
	public String actualizarTienda(@PathVariable(value = "id")int id, Model model) {
		Tienda tiendaEncontrada = service.buscarTienda(id);
		model.addAttribute("tienda", tiendaEncontrada);
		return "updateStore";
	}
	
	
	@GetMapping("/deleteStore/{id}")
	public String eliminarTienda(@PathVariable(value = "id")int id) {
		service.eliminarTienda(id);
		return "redirect:/tiendas/";
	}
	
	
}
