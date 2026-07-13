package Proyectos.POOConceptos;

import Proyectos.PreguntasDelCursoMVC.FileHandler;

/**
 * @file Main.java
 * @brief Clase principal del programa que permite crear, modificar y eliminar conceptos.
 * @date 29/03/2023
 * @version 1.0
 * @author Domingo Pérez
 */

/**
 * @class Main
 * @brief Clase principal que permite interactuar con la aplicación de conceptos.
 */
public class Main {
    
    /**
     * @brief Método principal que inicia la ejecución del programa.
     * @param args Parámetros de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        
         // Crear instancia de FileHandler para cargar las preguntas desde preguntas.txt
         FileHandler<Concepto> fileHandler = new FileHandler<Concepto>("Proyectos\\PreguntasDelCursoMVC\\preguntas.data");

         InicioVista vistaInicio = new InicioVista(fileHandler);
 
         vistaInicio.setVisible(true);
    }
}
