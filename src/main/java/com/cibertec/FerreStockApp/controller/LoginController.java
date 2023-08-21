
package com.cibertec.FerreStockApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.FerreStockApp.dto.UsuarioDto;
import com.cibertec.FerreStockApp.model.Trabajador;
import com.cibertec.FerreStockApp.model.Usuario;
import com.cibertec.FerreStockApp.service.impl.TrabajadorServiceImpl;
import com.cibertec.FerreStockApp.service.impl.UsuarioServiceImpl;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private TrabajadorServiceImpl trabajadorService;

	@GetMapping("/bienvenido")
	public String bienvenida() {
		return "bienvenido";
	}
	
	@GetMapping({"/login","/"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
	 return "accessDenied";
	}
	
	@GetMapping("/registration")
	public String registerForm(Model model) {
		UsuarioDto usuarioDto = new UsuarioDto();
		model.addAttribute("usuario",usuarioDto);
		return "registration";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("usuario") UsuarioDto usuarioDto,
			BindingResult result, Model model) {
		
		Usuario findUsuario = usuarioService.buscarUsuario(usuarioDto.getUsername());
		
		
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuarioDto);
			return "/registration";
		}

		Trabajador foundDni = trabajadorService.buscarTrabajadorPorDni(usuarioDto.getDni());
		if(foundDni != null)
			result.rejectValue("dni", null, "Dni already registered!");
		
		Trabajador foundEmail = trabajadorService.buscarTrabajadorPorEmail(usuarioDto.getEmail());
		if(foundEmail != null)
			result.rejectValue("email", null, "Email already registered!");
		
		if(findUsuario != null)
			result.rejectValue("username", null, "Usuario already registered!");
		
		//Guardar en dos tablas
		Trabajador nuevo = new Trabajador();
		nuevo.setNombres(usuarioDto.getNombres());
		nuevo.setApellidos(usuarioDto.getApellidos());
		nuevo.setDni(usuarioDto.getDni());
		nuevo.setCargo(usuarioDto.getCargo());
		nuevo.setEmail(usuarioDto.getEmail());
		nuevo.setSexo(usuarioDto.getSexo());
		trabajadorService.registrarTrabajador(nuevo);
		
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setUsername(usuarioDto.getUsername());
		usuarioNuevo.setPassword(usuarioDto.getPassword());
	
		usuarioService.agregarUsuario(usuarioNuevo);
		return "redirect:/registration?success";
		
		
	}
}
