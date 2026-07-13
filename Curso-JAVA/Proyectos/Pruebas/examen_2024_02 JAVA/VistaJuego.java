import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaJuego extends JFrame {
    private JLabel numeroLabel;
    private JButton siBoton;
    private JButton noBoton;
    private JLabel resultadoLabel;

    public VistaJuego() {
        numeroLabel = new JLabel("Número");
        siBoton = new JButton("Sí");
        noBoton = new JButton("No");
        resultadoLabel = new JLabel("Puntaje: 0");

        this.setLayout(new FlowLayout());
        this.add(numeroLabel);
        this.add(siBoton);
        this.add(noBoton);
        this.add(resultadoLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
    }

    public void addSiListener(ActionListener listener) {
        siBoton.addActionListener(listener);
    }

    public void addNoListener(ActionListener listener) {
        noBoton.addActionListener(listener);
    }

    public void mostrarNumero(int numero) {
        numeroLabel.setText("Número: " + numero);
    }

    public void actualizarResultado(int puntos, int acertadas, int erroneas) {
        resultadoLabel.setText("Puntaje: " + puntos + ", Acertadas: " + acertadas + ", Erróneas: " + erroneas);
    }
}