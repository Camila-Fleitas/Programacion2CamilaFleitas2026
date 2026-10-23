package com.cerp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cerp.controlador.InicioControlador;
import com.cerp.modelo.Tema;
import com.cerp.vista.InicioVista;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando POOShowcase...");

        // Ruta relativa para evitar errores entre diferentes entornos o computadoras
        String rutaArchivo = "src/main/resources/temas.data";
        FileHandler<Tema> fileHandler = new FileHandler<Tema>(rutaArchivo);

        List<Tema> modelo = new ArrayList<>();

        try {
            modelo = fileHandler.fileToList();
            System.out.println("Datos cargados correctamente. Se encontraron " + modelo.size() + " temas.");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("No se encontró el archivo de datos o está vacío. Se iniciará con una lista nueva.");
            modelo = new ArrayList<>();
        }

        // Inicialización de la arquitectura MVC
        InicioVista vistaInicio = new InicioVista(fileHandler);
        InicioControlador controlador = new InicioControlador(modelo, vistaInicio);
        vistaInicio.setControlador(controlador);
    }
}