package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarListaMatriDTO() {
		TypedQuery<MatriculaDTO> myQuery = this.entityManager.createQuery(
				"SELECT new com.example.demo.repository.modelo.dto.MatriculaDTO(e.cedula, mat.codigo, m.fechaMatricula, m.nombreHilo) FROM Matricula m JOIN m.estudiante e JOIN m.materias mat",
				MatriculaDTO.class);

		return myQuery.getResultList();
	}

}
