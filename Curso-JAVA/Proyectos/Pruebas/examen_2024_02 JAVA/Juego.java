import java.util.Random;

public class Juego {
    private Random random = new Random();
    private int puntos = 0;
    private int numerosCorrectos = 0;
    private int numerosIncorrectos = 0;

    public int obtenerNumeroAleatorio() {
        return random.nextInt(100) + 1;
    }

    public boolean esNumeroPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public void actualizarPuntaje(boolean acertado) {
        if (acertado) {
            puntos++;
            numerosCorrectos++;
        } else {
            puntos--;
            numerosIncorrectos++;
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public int getNumerosCorrectos() {
        return numerosCorrectos;
    }

    public int getNumerosIncorrectos() {
        return numerosIncorrectos;
    }
}