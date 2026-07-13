package Proyectos.Pruebas.parcial2_2023;

public class Juego {
    private int contador;
    private boolean juegoEnProgreso;

    public Juego() {
        contador = 0;
        juegoEnProgreso = false;
    }

    public int getContador() {
        return contador;
    }

    public void incrementarContador() {
        if (juegoEnProgreso) {
            contador++;
        }
    }

    public void iniciarJuego() {
        contador = 0;
        juegoEnProgreso = true;
    }

    public void detenerJuego() {
        juegoEnProgreso = false;
    }

    public boolean estaJuegoEnProgreso() {
        return juegoEnProgreso;
    }
}

