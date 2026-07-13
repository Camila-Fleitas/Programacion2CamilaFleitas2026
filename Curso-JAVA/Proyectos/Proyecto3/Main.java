package Proyecto3;

import java.util.Scanner;

/**
 * @file Main.java
 * @brief Clase principal para demostrar el funcionamiento de la biblioteca.
 * @author Curso programacion 3, año 2023
 * @date 15/08/2023
 */

public class Main {
    public static void main(String[] args) {

        // Creación de un autor 
        Autor autor1 = new Autor("Antoine de Saint-Exupéry", "Francés", "29/06/1900");
        
        // Creación de un libro y una revista usando el autor previamente creado
        Libro libro1 = new Libro("El Principito", autor1, 1943, "Infantil", "12345");
        Revista revista1 = new Revista("Ciencia Hoy", autor1, 2020, 150, "45678");
        Revista revista2 = new Revista("F1Total", autor1, 2022, 33, "333333");
        
        // Creación de la biblioteca y agregado de los materiales
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarMaterial(libro1);
        biblioteca.agregarMaterial(revista1);
        biblioteca.agregarMaterial(revista2);
        
        // Mostrar los materiales de la biblioteca (polimorfismo en acción)
        System.out.println("Materiales en la biblioteca:");
        biblioteca.mostrarMateriales();
        
        // Mostrar detalles adicionales usando la interfaz Mostrable (polimorfismo de interfaz)
        System.out.println("Detalles adicionales:");
        libro1.mostrarDetalle();
        revista1.mostrarDetalle();

        // Eliminar y volver a mostrar
        System.out.println("\nMATERIALES BIBLIOGRAFICOS ACTUALIZADOS");
        biblioteca.eliminarMaterial(revista1);
        biblioteca.mostrarMateriales();
        
        // Buscamos un material en específico
        System.out.println("\nBUSCAMOS POR TITULO UN MATERIAL BIBLIO");
        
        Scanner scan = new Scanner(System.in);
        String titu = scan.nextLine();
        scan.close();

        MaterialBibliografico material1 = new Revista();
        material1 = biblioteca.buscarMaterialPorTitulo(titu,1);
        
        if(material1 != null) {
            material1.setAnioPublicacion(1922);
            material1.setTitulo("F2Parcial");;
            material1.mostrar();
            biblioteca.agregarMaterial(material1);
        }
        
        

        System.out.println("\nFINAL ACTUALIZADOS");
        biblioteca.mostrarMateriales();
    }
}