package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

import jakarta.transaction.Transactional;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void guardar(Materia materia) {
		
		this.iMateriaRepository.insertar(materia);
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarPorCodigo(codigo);
	}
	

}
