package POOConceptos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import PreguntasDelCursoMVC.FileHandler;

/**
 * Clase para representar el controlador de la interfaz gráfica de administración de preguntas.
 */
public class AdminControlador implements ActionListener {

    private List<Concepto> modelo;
    private FileHandler<Concepto> fileHandler;
    private AdminVista vista;

    public AdminControlador(AdminVista vista) {
        this.fileHandler = vista.getFileHandler();
        this.vista = vista;

        vista.getConfirmarButton().addActionListener(this);
        vista.getAtrasButton().addActionListener(this);
        vista.getLimpiarButton().addActionListener(this);

        List<Concepto> modelo = new ArrayList<Concepto>();
        
        // Cargar las preguntas desde preguntas.txt
        try {
            modelo = fileHandler.fileToList();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        this.modelo = modelo;

        // Cargar la primera pregunta en la vista
        this.vista.actualizarPreguntaField();
        this.vista.actualizarOpcionesField();
        this.vista.actualizarCorrectaField();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getConfirmarButton()) {
            if (vista.getPreguntaField().getText().isEmpty() || vista.getOpcionesField().getText().isEmpty() || vista.getCorrectaField().getText().isEmpty()) {
                vista.mostrarMensajeError("Debe completar todos los campos.");
            } else {
                vista.getConfirmarButton().setEnabled(false); // Desactivar el botón de confirmar temporalmente

                String pregunta = vista.getPreguntaField().getText();
                String opcionesString = vista.getOpcionesField().getText();
                String correcta = vista.getCorrectaField().getText();

                String[] opciones = opcionesString.split(",");
                Concepto nuevaPregunta = new Concepto(modelo.size() + 1, pregunta, correcta, opciones);

                this.modelo.add(nuevaPregunta);
                try {
                    fileHandler.listToFile(modelo);
                } catch (IOException ex) {
                    vista.mostrarMensajeError("Ocurrió un error al escribir en el archivo: " + ex.getMessage());
                }

                vista.mostrarMensajeConfirmacion("Concepto agregada correctamente.");

                vista.setCurrentQuestionIndex(vista.getCurrentQuestionIndex() + 1);
                vista.getIdLabel().setText("ID de pregunta: " + (modelo.size() + 1));

                vista.actualizarPreguntaField();
                vista.actualizarOpcionesField();
                vista.actualizarCorrectaField();

                vista.getConfirmarButton().setEnabled(true); // Volver a activar el botón de confirmar
            }
        } else if (e.getSource() == vista.getAtrasButton()) {
            vista.getParentWindow().setVisible(true);
            vista.dispose();
        } else if (e.getSource() == vista.getLimpiarButton()) {
            try {
                fileHandler.limpiarArchivo();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            vista.getParentWindow().setVisible(true);
            vista.dispose();
        }
    }
}
