import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Juego juego = new Juego();
            VistaJuego vista = new VistaJuego();
            ControladorJuego controlador = new ControladorJuego(juego, vista);
            controlador.iniciarJuego();
        });
    }
}