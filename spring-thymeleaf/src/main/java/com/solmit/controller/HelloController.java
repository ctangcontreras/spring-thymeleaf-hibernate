package com.solmit.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.solmit.entidad.Usuario;
import com.solmit.service.UsuarioService;


@Controller
public class HelloController {

	@Autowired
	UsuarioService service;
	
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String name = "world";

		 
		try {
			
			List<Usuario>userLista=service.listarUsuarios();		
			
			for (Usuario usuario : userLista) {
				System.out.println(usuario.getIdUsuario());
			}
				
			modelAndView.addObject("name", name);
			modelAndView.setViewName("hello");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return modelAndView;
	}
}
