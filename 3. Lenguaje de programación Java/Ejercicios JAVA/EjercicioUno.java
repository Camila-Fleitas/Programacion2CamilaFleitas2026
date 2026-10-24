import java.util.Scanner;

public class EjercicioUno {

    public static void main(String[] args) {
        // Objeto Scanner para leer lo que el usuario escribe en el teclado
        Scanner scanner = new Scanner(System.in);

        // 1. Lectura de datos
        System.out.print("Ingrese la cantidad total de estudiantes: ");
        int totalEstudiantes = scanner.nextInt();

        System.out.print("Ingrese la cantidad de estudiantes por equipo: ");
        int estudiantesPorEquipo = scanner.nextInt();

        System.out.println();

        // 2. Mostrar los valores ingresados
        System.out.println("Cantidad total de estudiantes: " + totalEstudiantes);
        System.out.println("Estudiantes por equipo: " + estudiantesPorEquipo);

        // 3. Cálculos
        // La división entera calcula cuántos grupos completos caben
        int equiposCompletos = totalEstudiantes / estudiantesPorEquipo;

        // El operador módulo (%) calcula el resto de la división
        int estudiantesRestantes = totalEstudiantes % estudiantesPorEquipo;

        // 4. Mostrar los resultados
        System.out.println("Se pueden formar " + equiposCompletos + " equipos completos.");
        System.out.println("Quedan " + estudiantesRestantes + " estudiantes sin integrar un equipo.");

        scanner.close();
    }
}