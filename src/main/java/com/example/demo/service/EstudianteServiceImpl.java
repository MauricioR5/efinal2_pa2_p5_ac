package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;

import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void guardar(Estudiante estudiante) {
		this.iEstudianteRepository.insertar(estudiante);
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Estudiante buscarPorCedula(String cedula) {
		return this.iEstudianteRepository.seleccionarPorCedula(cedula);
	}

}
