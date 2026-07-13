package POOConceptos;

import java.awt.event.*;

import javax.swing.*;

import PreguntasDelCursoMVC.FileHandler;

/**
 * @file InicioVista.java
 * @brief Clase para el menú principal de la aplicación.
 * @date 20/03/2023
 * @version 1.0
 */
public class InicioVista extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenuItem adminMenuItem;
    private JMenuItem preguntasMenuItem;
    private FileHandler<Concepto> fileHandler;
    
    /**
     * Constructor para la clase InicioVista.
     * 
     * @param fileHandler El manejador de archivos de preguntas.
     */
    public InicioVista(FileHandler<Concepto> fileHandler) {
        super("Menú Principal");
        this.fileHandler = fileHandler;
        
        // Crear la barra de menú y agregarla a la ventana
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        // Crear los elementos del menú y agregarlos directamente a la barra de menú
        adminMenuItem = new JMenuItem("Administración");
        adminMenuItem.addActionListener(this);
        menuBar.add(adminMenuItem);
        
        preguntasMenuItem = new JMenuItem("Jugar");
        preguntasMenuItem.addActionListener(this);
        menuBar.add(preguntasMenuItem);
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Método para manejar los eventos de los botones.
     * 
     * @param e El evento que ha ocurrido.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminMenuItem) {
            // Crear instancia de AdminControlador y mostrar vista AdminVista
            AdminVista vistaAdmin = new AdminVista(fileHandler, this);
            AdminControlador controladorAdmin = new AdminControlador(vistaAdmin);
            // Asociar el controlador como listener de los componentes de la vista
            vistaAdmin.getConfirmarButton().addActionListener(controladorAdmin);
            vistaAdmin.getAtrasButton().addActionListener(controladorAdmin);
            vistaAdmin.getLimpiarButton().addActionListener(controladorAdmin);

        } else if (e.getSource() == preguntasMenuItem) {
            ConceptoVista preguntaVista = new ConceptoVista(fileHandler, this);
            preguntaVista.setVisible(true);
        }
        
        dispose();
    }
}
