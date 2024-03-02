package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
@EnableAsync
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(String cedula, String codigo1, String codigo2, String codigo3, String codigo4) {
	 

	    List<String> codigosMaterias = Arrays.asList(codigo1, codigo2, codigo3, codigo4);

	    codigosMaterias.parallelStream().forEach(codigoMateria -> {
	        Estudiante estudiante = this.iEstudianteRepository.seleccionarPorCedula(cedula);
	        Materia materia = this.iMateriaRepository.seleccionarPorCodigo(codigoMateria);

	        Matricula matricula = new Matricula();
	        matricula.setEstudiante(estudiante);
	        matricula.setFechaMatricula(LocalDate.now());
	        matricula.setNombreHilo(Thread.currentThread().getName());
	        matricula.setMaterias(new ArrayList<>(List.of(materia)));

	        iMatriculaRepository.insertar(matricula);
	    });
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public List<MatriculaDTO> buscarListaDTO() {
		return this.iMatriculaRepository.seleccionarListaMatriDTO();
	}

}
