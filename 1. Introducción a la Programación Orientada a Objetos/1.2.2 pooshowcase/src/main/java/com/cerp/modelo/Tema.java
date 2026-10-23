package com.cerp.modelo;

import java.io.Serializable;

/**
 * @class Tema
 * @brief Clase para representar un tema de POO en la aplicación.
 * Implementa Serializable para persistencia mediante FileHandler.
 */
public class Tema implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idTema;
    private String tema;       // Título del tema (ej. "Polimorfismo")
    private String correcta;   // Descripción / Definición extensiva
    private String[] opciones; // Contiene la URL de GitHub en el primer elemento [0]

    /**
     * Constructor principal
     */
    public Tema(int idTema, String tema, String correcta, String[] opciones) {
        this.idTema = idTema;
        this.tema = tema;
        this.correcta = correcta;
        this.opciones = opciones;
    }

    // Getters y Setters
    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    /**
     * Devuelve la URL de GitHub guardada en la primera posición del arreglo de opciones.
     */
    public String getUrlGithub() {
        if (opciones != null && opciones.length > 0) {
            return opciones[0];
        }
        return "";
    }

    public static Tema fromString(String temaString) {
        String[] fields = temaString.split("\\|");
        int idTema = Integer.parseInt(fields[0]);
        String tema = fields[1];
        String correcta = fields[2];
        String[] opciones = fields[3].split(",");

        return new Tema(idTema, tema, correcta, opciones);
    }
}