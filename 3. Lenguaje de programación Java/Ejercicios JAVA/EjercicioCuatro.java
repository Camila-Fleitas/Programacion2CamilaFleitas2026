import java.util.Random; // Se importa al principio

public class EjercicioCuatro {

    public static void main(String[] args) {
        Random random = new Random();
        
        // Genera directamente un entero de 1 a 7
        int numero = random.nextInt(7) + 1;
        
        String dia;
        switch (numero) {
            case 1: dia = "lunes"; break;
            case 2: dia = "martes"; break;
            case 3: dia = "miércoles"; break;
            case 4: dia = "jueves"; break;
            case 5: dia = "viernes"; break;
            case 6: dia = "sábado"; break;
            case 7: dia = "domingo"; break;
            default: dia = "inválido"; break;
        }
        
        System.out.println("Número generado: " + numero);
        System.out.println("Día correspondiente: " + dia);
    }
}