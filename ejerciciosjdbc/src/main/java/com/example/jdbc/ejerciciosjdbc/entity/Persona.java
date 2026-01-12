package com.example.jdbc.ejerciciosjdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	
	protected int id; 
	protected String nombre;
	protected ArrayList<String> direcciones;
		
	public Persona() {
		super();
		this.direcciones = new ArrayList<>();
	}

	public Persona(int id, String nombre, ArrayList<String> direcciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direcciones = direcciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(ArrayList<String> direcciones) {
		this.direcciones = direcciones;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", direcciones=" + direcciones + "]";
	} 
}
