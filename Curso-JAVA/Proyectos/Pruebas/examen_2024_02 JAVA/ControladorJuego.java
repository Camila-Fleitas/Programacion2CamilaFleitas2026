import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJuego {
    private Juego juego;
    private VistaJuego vista;
    private int numeroActual;

    public ControladorJuego(Juego juego, VistaJuego vista) {
        this.juego = juego;
        this.vista = vista;

        vista.addSiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarRespuesta(juego.esNumeroPrimo(numeroActual));
            }
        });

        vista.addNoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejarRespuesta(!juego.esNumeroPrimo(numeroActual));
            }
        });
    }

    private void manejarRespuesta(boolean acertado) {

        mostrarSiguienteNumero();

    }

    public void iniciarJuego() {
        vista.setVisible(true);
        mostrarSiguienteNumero();
    }

    private void mostrarSiguienteNumero() {

    }
}
