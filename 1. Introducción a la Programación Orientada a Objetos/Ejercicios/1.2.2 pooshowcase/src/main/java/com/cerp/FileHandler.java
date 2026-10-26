package com.cerp;

/**
 * @file FileHandler.java
 * @brief Clase para manejar archivos de temas.
 * @date 20/03/2023
 * @version 1.0
 * @author Domingo Pérez
 */

 import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
 /**
  * @class FileHandler
  * @brief Clase para manejar archivos de temas.
  */
public class FileHandler<T> {
    
    private String filename;
    
    /**
     * Constructor de la clase FileHandler.
     * 
     * @param filename nombre del archivo a manejar.
     */
    public FileHandler(String filename) {
        this.filename = filename;
    }
    
    /**
     * Lee los temas desde el archivo.
     * 
     * @return una lista de temas.
     * @throws IOException si ocurre un error de entrada/salida.
     * @throws ClassNotFoundException si la clase de algún objeto serializado no puede ser encontrada.
     */
    @SuppressWarnings("unchecked")
    public List<T> fileToList() throws IOException, ClassNotFoundException {
        List<T> miLista = new ArrayList<T>();
        
        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        
        miLista = (List<T>) objectInputStream.readObject();
        
        objectInputStream.close();
        fileInputStream.close();
        
        return miLista;
    }
    
    /**
     * Escribe los temas en el archivo.
     * 
     * @param miLista la lista de temas a escribir.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public void listToFile(List<T> miLista) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        
        objectOutputStream.writeObject(miLista);
        
        objectOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * Limpia el contenido del archivo especificado.
     * 
     * @throws IOException si ocurre un error de entrada/salida.
     */
    public void limpiarArchivo() throws IOException {
        FileWriter fileWriter = new FileWriter(filename, false);
        fileWriter.write("");
        fileWriter.close();
    }

}