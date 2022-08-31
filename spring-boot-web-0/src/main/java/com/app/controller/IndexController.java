package com.app.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({"/home","/","index"})
	public String index(Model model) {
		model.addAttribute("titulo","hola spring framework");
	
		return "index";
	}
	
	@RequestMapping("/*perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jared");
		usuario.setApellido("Molina"); 
		usuario.setEmail("jaredpineda033@gmail.com");
		model.addAttribute("usuario",usuario);   
		model.addAttribute("titulo","hola spring framework  ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping ("/listar")
	public String listar(Model model) {
		Usuario usuario = new Usuario();
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Matthew","Pineda","matthew12pineda@gmail.com"),
				new Usuario("Jared","Molina","jared12pineda@gmail.com"),
				new Usuario("Mateo","Rodriguez","mateo12pineda@gmail.com")); 
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("titulo","Listado de usuario ");
		return "listar";
	}
	
	
	
	
}