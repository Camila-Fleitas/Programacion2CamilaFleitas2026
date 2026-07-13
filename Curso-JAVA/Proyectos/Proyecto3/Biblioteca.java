package Proyectos.Proyecto3;

import java.util.ArrayList;
//import java.util.List;
import java.util.Collection;

/**
 * @file Biblioteca.java
 * @brief Clase que representa una biblioteca.
 * @author Curso programacion 3, año 2023
 * @date 15/08/2023
 */

public class Biblioteca {
    // Lista de materiales bibliográficos
    //private List<MaterialBibliografico> materiales;
    private Collection<MaterialBibliografico> materiales;

    public Collection<MaterialBibliografico> getMateriales() {
        return materiales;
    }

    public void setMateriales(Collection<MaterialBibliografico> materiales) {
        this.materiales = materiales;
    }

    // Constructor
    public Biblioteca() {
        this.materiales = new ArrayList<>();
        //this.materiales = new LinkedList<>();
        
    }

    // Método para agregar un material bibliográfico
    public void agregarMaterial(MaterialBibliografico material) {
        materiales.add(material);
    }

    // Método para eliminar un material bibliográfico
    public void eliminarMaterial(MaterialBibliografico material) {
        materiales.remove(material);
    }

    // Método para buscar un material bibliográfico
    public MaterialBibliografico buscarMaterialPorTitulo(String titulo, int estado) {      
        for (MaterialBibliografico mat : materiales) {          
            if (mat.getTitulo().equals(titulo)) {
                if (estado == 0) return mat;
                if (estado == 1) return mat.clone();
            }
             // no utilizar en String comparacion con ==, como en C debo utilizar otra forma.
        }
        return null;
    }


 // Método para modificar un material bibliográfico
    public void modificarMaterial(MaterialBibliografico material) {
        materiales.remove(material);
    }







    
    // Método para mostrar todos los materiales (usando el método polimórfico 'mostrar()')
    public void mostrarMateriales() {
        for (MaterialBibliografico material : materiales) {
            material.mostrar();
            System.out.println("-------------------------------");
        }
    }
}
