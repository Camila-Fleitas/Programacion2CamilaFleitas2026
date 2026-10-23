package com.cerp.vista;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.cerp.FileHandler;
import com.cerp.controlador.InicioControlador;
import com.cerp.modelo.Tema;

/**
 * @file InicioVista.java
 * @brief Vista principal del menú de la aplicación POOShowcase.
 */
public class InicioVista extends JFrame {
    private JMenuBar menuBar;
    private JMenuItem menuItemAdmin;
    private JMenuItem menuItemTemas;
    private JLabel numTemas; 

    private FileHandler<Tema> fileHandler;
    private InicioControlador controlador;

    public InicioVista(FileHandler<Tema> fileHandler) {
        super("Menú Principal - POOShowcase");
        this.fileHandler = fileHandler;
        
        initComponents();

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (controlador != null) {
                    controlador.guardarTemas();
                }
                System.exit(0);
            }
        });
    }

    private void initComponents() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuItemAdmin = new JMenuItem("Administración");
        menuBar.add(menuItemAdmin);

        menuItemTemas = new JMenuItem("Explorar POO");
        menuBar.add(menuItemTemas);

        JPanel inicioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        numTemas = new JLabel("Hay en el sistema 0 temas de POO");
        inicioPanel.add(numTemas);

        add(inicioPanel);

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public FileHandler<Tema> getFileHandler() {
        return fileHandler;
    }

    public void setFileHandler(FileHandler<Tema> fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void setControlador(InicioControlador controlador) {
        this.controlador = controlador;
    }

    public InicioControlador getControlador() {
        return this.controlador;
    }

    public JMenuItem getItemAdmin() {
        return menuItemAdmin;
    }

    public JMenuItem getItemTemas() {
        return menuItemTemas;
    }

    public JLabel getLabelTemas() {
        return numTemas;
    }

    public void setLabelTemas(JLabel numTemas) {
        this.numTemas = numTemas;
    }
}