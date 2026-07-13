package Proyectos.Proyecto3;

/**
 * @file Revista.java
 * @brief Clase que representa una revista en la biblioteca.
 * Esta clase hereda de MaterialBibliografico y además implementa la interfaz Mostrable.
 * @author Curso programacion 3, año 2023
 * @date 15/08/2023
 */

public class Revista extends MaterialBibliografico implements Mostrable {
    // Atributos específicos de una revista
    private int numeroEdicion;
    private String ISSN;

    // Constructor
    public Revista(String titulo, Autor autor, int anioPublicacion, int numeroEdicion, String ISSN) {
        super(titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.ISSN = ISSN;
    }

    public Revista() {
        
    }

    // Implementación del método abstracto de la superclase
    @Override
    public void mostrar() {
        System.out.println("Revista:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor().getNombre());
        System.out.println("Año de Publicación: " + getAnioPublicacion());
        System.out.println("Número de Edición: " + numeroEdicion);
        System.out.println("ISSN: " + ISSN);
    }

    // Implementación del método de la interfaz Mostrable
    @Override
    public void mostrarDetalle() {
        System.out.println("Detalles de la revista:");
        System.out.println("Título: " + getTitulo());
        System.out.println("ISSN: " + ISSN);
    }

    // Getters y Setters
    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }
}
