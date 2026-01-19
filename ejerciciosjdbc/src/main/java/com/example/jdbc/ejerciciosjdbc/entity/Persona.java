package com.example.jdbc.ejerciciosjdbc.entity;

import java.util.ArrayList;

public class Persona {
    
    protected int id; 
    protected String nombre;
    protected int edad; 
    protected ArrayList<String> direcciones;
        
    public Persona() {
        super();
        this.direcciones = new ArrayList<>();
    }

    public Persona(int id, String nombre, int edad, ArrayList<String> direcciones) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(ArrayList<String> direcciones) {
        this.direcciones = direcciones;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
    } 
}
