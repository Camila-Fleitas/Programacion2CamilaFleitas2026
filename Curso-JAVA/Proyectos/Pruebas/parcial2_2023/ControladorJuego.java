package Proyectos.Pruebas.parcial2_2023;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJuego {
    private Juego juego;
    private VistaJuego vista;
    private Timer timer;

    public ControladorJuego(Juego juego, VistaJuego vista) {
        this.juego = juego;
        this.vista = vista;

        this.vista.addIniciarJuegoListener(new IniciarJuegoListener());
        this.vista.addDetenerJuegoListener(new DetenerJuegoListener());

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (juego.estaJuegoEnProgreso()) {
                    juego.incrementarContador();
                    vista.actualizarContador(juego.getContador());
                }
            }
        });
    }

    public void iniciarJuego() {
        vista.setVisible(true);
    }

    class IniciarJuegoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            juego.iniciarJuego();
            vista.actualizarContador(juego.getContador());
            timer.start();
        }
    }

    class DetenerJuegoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            juego.detenerJuego();
            timer.stop();
            vista.mostrarResultado(juego.getContador());
        }
    }
}


