package com.cibertec.FerreStockApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.FerreStockApp.model.Usuario;
import com.cibertec.FerreStockApp.service.impl.UsuarioServiceImpl;

import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UsuarioServiceImpl usuarioService;

	@GetMapping("/bienvenido")
	public String bienvenida() {
		return "bienvenido";
	}
	
	@GetMapping({"/login","/"})
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registerForm(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario",usuario);
		return "registration";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult result, Model model) {
		
		Usuario findUsuario = usuarioService.buscarUsuario(usuario.getUsername());
		
		if(findUsuario != null)
			result.rejectValue("username", null, "Usuario already registered!");
		
		if(result.hasErrors()) {
			model.addAttribute("usuario", usuario);
			return "/registration";
		}
		
		usuarioService.agregarUsuario(usuario);
		return "redirect:/registration?success";
	}
}
