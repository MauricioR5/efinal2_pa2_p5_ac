package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.IMatriculaService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private IMatriculaService iMatriculaService;

	@GetMapping("/nuevaMatricula")
	private String nuevaMatricula(Matricula matricula) {
		return "vistaNuevaMatricula";
	}

	@PostMapping("/ingresarMatricula")
	private String ingresarMatricula(@ModelAttribute Matricula matricula) {
		String cedula = matricula.getEstudiante().getCedula();
		String codigo1 = matricula.getMaterias().get(0).getCodigo();
		String codigo2 = matricula.getMaterias().get(1).getCodigo();
		String codigo3 = matricula.getMaterias().get(2).getCodigo();
		String codigo4 = matricula.getMaterias().get(3).getCodigo();

		this.iMatriculaService.guardar(cedula, codigo1, codigo2, codigo3, codigo4);
		return "redirect:/matriculas/nuevaMatricula";
	}

	@GetMapping("/listaMatriculas")
	    private String listaMatriculas(Model model){
	        List<MatriculaDTO> lista = this.iMatriculaService.buscarListaDTO();
	        model.addAttribute("lista", lista);
	        return "vistaListaMatriculas";
	    }
}