// Se importa la herramienta Random del paquete java.util para generar números aleatorios
import java.util.Random;

public class EjercicioDos {

    public static void main(String[] args) {
        // Instancia para la generación de números al azar
        Random random = new Random();

        // 1. Genera un número aleatorio m entre 1 y 20 (inclusive)
        int m = random.nextInt(20) + 1;

        // Muestra en pantalla el número límite m generado
        System.out.println("Número límite generado (m): " + m);

        // Variable acumuladora para almacenar la suma total
        int suma = 0;

        // 2. Estructura repetitiva que recorre los números desde 1 hasta m
        for (int i = 1; i <= m; i++) {
            suma += i; // Acumula el valor actual de i en la variable suma
        }

        // 3. Muestra el resultado final calculado
        System.out.println("La suma de todos los números desde 1 hasta " + m + " es: " + suma);
    }
}