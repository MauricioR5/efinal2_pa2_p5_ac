package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaService {

public void guardar(String cedula, String codigo, String codigo2, String codigo3, String codigo4);
	
	public List<MatriculaDTO> buscarListaDTO();
	
	
}
