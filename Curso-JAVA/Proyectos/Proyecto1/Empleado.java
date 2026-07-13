/**
 * @file Empleado.java
 * @brief Clase que representa a un empleado
 * @author Domingo Pérez
 * @date 19/03/2023
*/

public class Empleado {
    
    private String nombre;
    private int id;
    private float salarioMensual;
    
    /**
     * Constructor de la clase Empleado
     * @param nombre Nombre del empleado
     * @param id Identificador del empleado
     * @param salarioMensual Salario mensual del empleado
     */
    public Empleado(String nombre, int id, float salarioMensual) {
        this.nombre = nombre;
        this.id = id;
        this.salarioMensual = salarioMensual;
    }
    
    /**
     * Método que devuelve el nombre del empleado
     * @return Nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método que devuelve el identificador del empleado
     * @return Identificador del empleado
     */
    public int getId() {
        return id;
    }
    
    /**
     * Método que devuelve el salario mensual del empleado
     * @return Salario mensual del empleado
     */
    public float getSalarioMensual() {
        return salarioMensual;
    }
    
    /**
     * Método que modifica el salario mensual del empleado
     * @param salarioMensual Nuevo salario mensual del empleado
     */
    public void setSalarioMensual(float salarioMensual) {
        this.salarioMensual = salarioMensual;
    }
}
