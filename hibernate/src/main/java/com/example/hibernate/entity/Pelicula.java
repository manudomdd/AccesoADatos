package com.example.hibernate.entity;

public class Pelicula {

    private int id;
    private String titulo;
    private String genero;
    private int estreno;

    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, int estreno) {
        this.titulo = titulo;
        this.genero = genero;
        this.estreno = estreno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + "]";
    }
}