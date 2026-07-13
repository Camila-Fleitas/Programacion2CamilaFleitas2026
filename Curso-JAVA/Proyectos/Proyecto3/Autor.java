package Proyectos.Proyecto3;

/**
 * @file Autor.java
 * @brief Clase que representa a un autor de material bibliográfico.
 * @author Curso programacion 3, año 2023
 * @date 15/08/2023
 */

public class Autor {
    // Atributos de un autor
    private String nombre;
    private String nacionalidad;
    private String fechaNacimiento;

    // Constructor
    public Autor(String nombre, String nacionalidad, String fechaNacimiento) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método para mostrar detalles del autor
    public void mostrar() {
        System.out.println("Autor:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}

