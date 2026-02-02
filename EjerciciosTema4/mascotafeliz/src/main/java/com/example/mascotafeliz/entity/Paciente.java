package com.example.mascotafeliz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="pacientes_veterinaria")

public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id; 
	
	@Column
	private String nombre; 
	
	@Column
	private String especie; 
	
	@Column(unique = true, length = 15, nullable = false)
	private String chip; 
	
	@Column
	private Double peso;	

	public Paciente() {
		super();
	}

	public Paciente(long id, String nombre, String especie, String chip, Double peso) {
		super();
		Id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.chip = chip;
		this.peso = peso;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Paciente [Id=" + Id + ", nombre=" + nombre + ", especie=" + especie + ", chip=" + chip + ", peso="
				+ peso + "]";
	} 	
}
