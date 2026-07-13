
import java.util.ArrayList;
import java.util.List;
//import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;


/**
 * @file Biblioteca.java
 * @brief Clase que representa una biblioteca.
 * @author Curso programacion 3, año 2023
 * @date 06/09/2023
 */

public class Biblioteca {
    // Lista de materiales bibliográficos
    //private List<MaterialBibliografico> listaMateriales;
    private Hashtable<String, MaterialesBibliograficos> materiales;

    public Hashtable<String, MaterialesBibliograficos> getMateriales() {
        return materiales;
    }

    public void setMateriales(Hashtable<String,MaterialesBibliograficos> materiales) {
        this.materiales = materiales;
    }

    // Constructor
    public Biblioteca() {
        //this.materiales = new ArrayList<>();
        //this.materiales = new LinkedList<>();
        this.materiales = new Hashtable<>();
    }

    // Método para agregar un material bibliográfico
    public void agregarMaterial(String genero, MaterialBibliografico material) {
        // Obtén la lista de materiales para el género dado
    MaterialesBibliograficos aux = materiales.get(genero);


    // Si la lista no existe, crea una nueva
    if (aux== null) {
        
        materiales.put(genero, aux);
    }

    // Agrega el material a la lista
    aux.agregarMaterial(material);
        
        //materiales.add(material);
        //materiales.put(genero, material); // no utilizar put porque reemplaza el valor anterior, solo si deseo cargar 1 MatBib por Genero
        List<MaterialBibliografico> l = materiales.get(genero);
        new ArrayList<>();

        if (materiales.get(genero)==null)
            materiales.put(genero, null);
        materiales.get(genero).agregarMaterial(material);  
    }

    // Método para eliminar un material bibliográfico
    public void eliminarMaterial(String genero,MaterialBibliografico material) {
        //materiales.remove(material);
        materiales.remove(genero, material);
    }

    // Método para buscar un material bibliográfico
    public MaterialBibliografico buscarMaterialPorTitulo(String titulo, int estado) {      
        /*for (MaterialBibliografico mat : materiales) {          
            if (mat.getTitulo().equals(titulo)) {
                if (estado == 0) return mat;
                if (estado == 1) return mat.clone();
            }
             // no utilizar en String comparacion con ==, como en C debo utilizar otra forma.
        }*/
        return null;
    }


 // Método para modificar un material bibliográfico
    public void modificarMaterial(String genero,MaterialBibliografico material) {
        //materiales.remove(material);
    }







    
    // Método para mostrar todos los materiales (usando el método polimórfico 'mostrar()')
    public void mostrarMateriales() {
        /*for (MaterialBibliografico material : materiales) {
            material.mostrar();
            System.out.println("-------------------------------");
        }*/
/* 
        // Iterating using enhanced for loop
        for (Map.Entry<String, MaterialBibliografico> e : materiales.entrySet())
            System.out.println(e.getKey() + " "
                               + e.getValue());
*/
        // Iterating using enhanced for loop
        for (Map.Entry<String, MaterialesBibliograficos> e : materiales.entrySet()){
            System.out.println("La llave KEY es "+e.getKey() + " ");
            e.getValue().mostrarMateriales();
    }


    }
}
