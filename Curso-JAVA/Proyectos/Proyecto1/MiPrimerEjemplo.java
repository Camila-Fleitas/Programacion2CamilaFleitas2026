/**
 * @file MiPrimerEjemplo.java
 * @brief Ejemplo de creación e impresión de un objeto de tipo Empleado.
 * @author Domingo Pérez
 * @date 19/03/2023
 */

 

 public class MiPrimerEjemplo {
   public static void main(String[] args) {
       // Creación del objeto empleado
       Empleado empleado1 = new Empleado("Juan Perez", 123456, 15000.0f);

       // Impresión de la información del empleado
       System.out.println("Nombre: " + empleado1.getNombre());
       System.out.println("ID: " + empleado1.getId());
       System.out.println("Salario mensual: $" + empleado1.getSalarioMensual());

       //System.out.println("Hola nada mas");
   }
}
