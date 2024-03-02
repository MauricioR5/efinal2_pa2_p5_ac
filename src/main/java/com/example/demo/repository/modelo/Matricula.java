	package com.example.demo.repository.modelo;
	
	import java.time.LocalDate;
	import java.util.List;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.JoinTable;
	import jakarta.persistence.ManyToMany;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.SequenceGenerator;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "matricula")
	public class Matricula {
	
		@Id
		@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
		@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
		@Column(name = "matri_id")
		private Integer id;
	
		@Column(name = "matri_fecha")
		private LocalDate fechaMatricula;
	
		@Column(name = "matri_nombreHilo")
		private String nombreHilo;
		
		@ManyToOne
		@JoinColumn(name = "matri_id_estudiante")
		private Estudiante estudiante;
	
		@ManyToMany
		@JoinTable(name = "matri_id_materia", joinColumns = @JoinColumn(name = "matri_id"), inverseJoinColumns = @JoinColumn(name = "mate_id"))
		private List<Materia> materias;
	
		//set and get
	
		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		public LocalDate getFechaMatricula() {
			return fechaMatricula;
		}
	
		public void setFechaMatricula(LocalDate fechaMatricula) {
			this.fechaMatricula = fechaMatricula;
		}
	
		public Estudiante getEstudiante() {
			return estudiante;
		}
	
		public void setEstudiante(Estudiante estudiante) {
			this.estudiante = estudiante;
		}
	
		public String getNombreHilo() {
			return nombreHilo;
		}
	
		public void setNombreHilo(String nombreHilo) {
			this.nombreHilo = nombreHilo;
		}
	
		public List<Materia> getMaterias() {
			return materias;
		}
	
		public void setMaterias(List<Materia> materias) {
			this.materias = materias;
		}
	
	}