// Se importa la herramienta Random del paquete java.util para poder generar números aleatorios
import java.util.Random;

public class EjercicioTres {

    public static void main(String[] args) {
        // Se crea una instancia (objeto) de la clase Random llamada 'random'
        Random random = new Random();
        
        // Declaro e inicializo la variable acumuladora para los números impares en 0
        int sumaImpares = 0;
        
        // Ciclo while: se repetirá MIENTRAS la suma acumulada sea menor o igual a 25
        while (sumaImpares <= 25) {
            
            // Genera un número entero aleatorio en el rango de 0 a 10 inclusive (el 11 es el límite exclusivo)
            int numero = random.nextInt(11);
            
            // Condicional: verifico si el resto de dividir 'numero' entre 2 es igual a 0
            if (numero % 2 == 0) {
                // Si el resto es 0, el número es par y solo se muestra en consola
                System.out.println("Número generado: " + numero + " - Es par");
            } else {
                // Si el resto no es 0, el número es impar
                System.out.println("Número generado: " + numero + " - Es impar");
                
                // Acumulamos/sumamos el número impar a la variable (equivale a: sumaImpares = sumaImpares + numero)
                sumaImpares += numero;
            }
        }
        
        // Al romper el ciclo (cuando sumaImpares pasa de 25), se imprime una línea en blanco y el resultado final
        System.out.println();
        System.out.println("La suma de los números impares es: " + sumaImpares);
        System.out.println("La suma superó el valor 25. El proceso ha finalizado.");
    }
}