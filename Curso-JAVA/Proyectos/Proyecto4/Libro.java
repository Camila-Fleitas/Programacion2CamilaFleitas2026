
/**
 * @file Libro.java
 * @brief Clase que representa un libro en la biblioteca.
 * Esta clase hereda de MaterialBibliografico y además implementa la interfaz Mostrable.
 * @author Curso programacion 3, año 2023
 * @date 15/08/2023
 */

public class Libro extends MaterialBibliografico implements Mostrable {
    // Atributos específicos de un libro
    private String ISBN;

    // Constructor
    public Libro(String titulo, String genero, Autor autor, int anioPublicacion, String ISBN) {
        super(titulo, genero, autor, anioPublicacion);
        this.ISBN = ISBN;
    }

    // Implementación del método abstracto de la superclase
    @Override
    public void mostrar() {
        System.out.println("Libro:");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor().getNombre());
        System.out.println("Año de Publicación: " + getAnioPublicacion());
        System.out.println("ISBN: " + ISBN);
    }

    // Implementación del método de la interfaz Mostrable
    @Override
    public void mostrarDetalle() {
        System.out.println("Detalles del libro:");
        System.out.println("Título: " + getTitulo());
        System.out.println("ISBN: " + ISBN);
    }

    // Getters y Setters
 

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
