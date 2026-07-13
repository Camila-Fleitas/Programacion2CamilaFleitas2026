package POOConceptos;

/**
 * @file Concepto.java
 * @brief Clase para representar una concepto en el juego de preguntas y respuestas.
 * @date 20/03/2023
 * @version 1.0
 */

 import java.io.Serializable;

 /**
  * @class Concepto
  * @brief Clase para representar una concepto en el juego de preguntas y respuestas.
  * Implementa Serializable para poder ser guardada en un archivo.
  */
 public class Concepto implements Serializable{
    private int idConcepto; // índice de la concepto
    private String concepto; // concepto
    private String descripcion; // respuesta descripcion
    private String[] etiquetas; // etiquetas posibles

    /**
     * Constructor para la clase concepto.
     * @param idConcepto int que representa el numero de concepto
     * @param concepto String que representa la concepto.
     * @param etiquetas String[] que contiene las etiquetas posibles.
     * @param answerIndex int que representa el índice de la respuesta descripcion en el arreglo etiquetas.
     */
    public Concepto(int idConcepto, String concepto, String descripcion, String[] etiquetas) {
        this.idConcepto = idConcepto;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.etiquetas = etiquetas;
    }

    /**
     * Getter para obtener el id de la concepto.
     * @return int que representa el id de la concepto.
     */
    public int getIdConcepto() {
        return idConcepto;
    }

    /**
     * Setter para establecer el id de la concepto.
     * @param idConcepto int que representa el id de la concepto.
     */
    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    /**
     * Getter para obtener la concepto.
     * @return String que representa la concepto.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Setter para establecer la concepto.
     * @param concepto String que representa la concepto.
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Getter para obtener la respuesta descripcion.
     * @return String que representa la respuesta descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter para establecer la respuesta descripcion.
     * @param descripcion String que representa la respuesta descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter para obtener las etiquetas posibles.
     * @return String[] que contiene las etiquetas posibles.
     */
    public String[] getEtiquetas() {
        return etiquetas;
    }


    public static Concepto fromString(String ConceptoString) {
        // Separar la cadena en los diferentes campos
        String[] fields = ConceptoString.split("\\|");

        System.out.println("ID de concepto: " + fields[0]);
        System.out.println("Concepto: " + fields[1]);
        System.out.println("Descripcion: " + fields[2]);
        System.out.println("Etiquetas: " + fields[3]);
    
        // Crear la concepto a partir de los campos
        int idConcepto = Integer.parseInt(fields[0]);
        String concepto = fields[1];
        String descripcion = fields[2];
        String[] etiquetas = fields[3].split(",");
    
        return new Concepto(idConcepto, concepto, descripcion, etiquetas);
    }
}
