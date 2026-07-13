package Proyectos.Proyecto3;

/**
 * @file MaterialBibliografico.java
 * @brief Clase abstracta que representa un material bibliográfico genérico.
 * @author Curso programacion 3, año 2023
 * @date 15/08/2023
 */

public abstract class MaterialBibliografico implements Cloneable {
    // Atributos comunes para cualquier material bibliográfico
    private String titulo;
    private Autor autor;
    private int anioPublicacion;

    // Constructor
    public MaterialBibliografico(String titulo, Autor autor, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public MaterialBibliografico() {
        
    }

    @Override
    public MaterialBibliografico clone() {
        try {
            return (MaterialBibliografico) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("La clase no soporta clonación", e);
        }
    }

    // Método abstracto para mostrar detalles del material
    public abstract void mostrar();

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
}
