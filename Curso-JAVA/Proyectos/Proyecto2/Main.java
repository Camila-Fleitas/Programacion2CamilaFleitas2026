package Proyecto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creación de objetos para pruebas
        Libro libro1 = new Libro("El Principito", "Infantil", "12345");
        Autor autor1 = new Autor("Antoine de Saint-Exupéry", "Francés");

				Libro libro3 = new Libro();
			
        // Mostrar libro y autor
        System.out.println("Detalles del Libro 1:");
        libro1.mostrarLibro();
        System.out.println("\nDetalles del Autor 1:");
        autor1.mostrarAutor();

        // Solicitar la carga de un nuevo libro
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese los detalles de un nuevo libro:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("ISBN: ");
        String ISBN = scanner.nextLine();

        Libro libro2 = new Libro(titulo, genero, ISBN);
        System.out.println("\nDetalles del Libro 2:");
        libro2.mostrarLibro(5);

       
        scanner.close();
    }
}
