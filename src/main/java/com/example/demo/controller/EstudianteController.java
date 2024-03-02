package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService iEstudianteService;

	@GetMapping("/nuevoEstudiante")
	private String nuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}

	@PostMapping("/ingresarEstudiante")
	private String ingresarEstudiante(Estudiante estudiante) {
		this.iEstudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";
	}
}
