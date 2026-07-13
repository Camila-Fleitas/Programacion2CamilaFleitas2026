package Proyectos.Pruebas.parcial2_2023;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaJuego extends JFrame {
    private JLabel contadorLabel;
    private JButton iniciarJuegoButton;
    private JButton detenerJuegoButton;
    private JLabel resultadoLabel;

    public VistaJuego() {
        contadorLabel = new JLabel("0");
        iniciarJuegoButton = new JButton("Iniciar Juego");
        detenerJuegoButton = new JButton("Detener Juego");
        resultadoLabel = new JLabel("");

        this.setLayout(new GridLayout(4, 1));
        this.add(contadorLabel);
        this.add(iniciarJuegoButton);
        this.add(detenerJuegoButton);
        this.add(resultadoLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
    }

    public void addIniciarJuegoListener(ActionListener listener) {
        iniciarJuegoButton.addActionListener(listener);
    }

    public void addDetenerJuegoListener(ActionListener listener) {
        detenerJuegoButton.addActionListener(listener);
    }

    public void actualizarContador(int contador) {
        contadorLabel.setText("Contador: " + contador);
    }

    public void mostrarResultado(int contador) {
        resultadoLabel.setText("Resultado: " + contador);
    }
}

