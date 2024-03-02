package com.example.demo.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDTO {

	private String cedula;
	private String codigoMateria;
	private LocalDate fechaMatricula;
	private String nombreHilo;

	public MatriculaDTO() {

	}

	public MatriculaDTO(String cedula, String codigoMateria, LocalDate fechaMatricula, String nombreHilo) {
		this.cedula = cedula;
		this.codigoMateria = codigoMateria;
		this.fechaMatricula = fechaMatricula;
		this.nombreHilo = nombreHilo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}
	
	
}
