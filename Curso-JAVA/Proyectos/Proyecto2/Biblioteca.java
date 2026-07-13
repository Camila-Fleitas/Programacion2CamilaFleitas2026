/**
 * @file Biblioteca.java
 * @brief Ejemplo de creacion de clase Libro y clase Autor 
 * para la gestion de una biblioteca. Se trabaja tambien los conceptos de 
 * metodos constructores, setter and getter, sobrecarga de metodos.
 * @author Curso programacion 3, anio 2023
 * @date 08/08/2023
 */

package Proyecto2;

// Definición de la clase Libro
class Libro {
    // Atributos
    private String titulo;
    private String genero;
    private String ISBN;

    // Constructor por defecto
    public Libro() {
        this.titulo = "";
        this.genero = "";
        this.ISBN = "";
    }

    // Constructor con parámetros
    /**
     * Constructor de la clase Libro
     * @param titulo del Libro
     * @param genero del Libro
     * @param ISBN del Libro
     */
    public Libro(String titulo, String genero, String ISBN) {
        this.titulo = titulo;
        this.genero = genero;
        this.ISBN = ISBN;
    }

    // Método para mostrar un libro
    public void mostrarLibro() {
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("ISBN: " + ISBN);
    }

		public void mostrarLibro(int enter) {
        for (int i=0;i<enter;i++){
						System.out.println("#");
				}  
				System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
    }

    // Getters y Setters
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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}

// Definición de la clase Autor
class Autor {
    // Atributos
    private String nombre;
    private String nacionalidad;

    // Constructor por defecto
    public Autor() {
        this.nombre = "";
        this.nacionalidad = "";
    }

    // Constructor con parámetros
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Método para mostrar un autor
    public void mostrarAutor() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
