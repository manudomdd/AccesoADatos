package com.example.jdbc.ejerciciosjdbc.entity;

public class Telefono {
	
	protected int id; 
	protected String numero; 
	protected String tipo; 
	protected int id_persona;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getId_persona() {
		return id_persona;
	}
	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	@Override
	public String toString() {
		return "Telefono [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", id_persona=" + id_persona + "]";
	} 
}
