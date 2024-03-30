package com.leotoloza.peliculas.Modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String reseña;
    private int imagen;
    private String actores;
    private String director;

    public Pelicula(String titulo, String reseña, int imagen, String actores, String director) {
        this.titulo = titulo;
        this.reseña = reseña;
        this.imagen = imagen;
        this.actores = actores;
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getReseña() {
        return reseña;
    }

    public void setReseña(String reseña) {
        this.reseña = reseña;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}