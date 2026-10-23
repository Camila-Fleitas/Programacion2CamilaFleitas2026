package com.cerp.vista;

import javax.swing.*;
import java.awt.*;

/**
 * @file TemaVista.java
 * @brief Interfaz gráfica para la exploración de conceptos y apertura de enlaces a GitHub.
 */
public class TemaVista extends JFrame {
    private JLabel idLabel;
    private JLabel temaLabel;
    private JTextArea descripcionArea;

    private JButton siguienteButton;
    private JButton githubButton;
    private JButton atrasButton;

    private InicioVista parentWindow;

    public TemaVista(InicioVista parentWindow) {
        super("Explorador de Temas - POOShowcase");
        this.parentWindow = parentWindow;
        
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        idLabel = new JLabel("ID de tema: 1");
        idLabel.setFont(new Font("Arial", Font.BOLD, 12));
        infoPanel.add(idLabel);

        temaLabel = new JLabel("Concepto: ");
        temaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(temaLabel);
        infoPanel.add(Box.createVerticalStrut(10));

        descripcionArea = new JTextArea(8, 30);
        descripcionArea.setEditable(false);
        descripcionArea.setLineWrap(true);
        descripcionArea.setWrapStyleWord(true);
        descripcionArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(descripcionArea);

        infoPanel.add(scrollPane);
        add(infoPanel, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel(new FlowLayout());

        githubButton = new JButton("Ver Ejemplo en GitHub");
        siguienteButton = new JButton("Siguiente Tema");
        atrasButton = new JButton("Atrás");

        actionPanel.add(githubButton);
        actionPanel.add(siguienteButton);
        actionPanel.add(atrasButton);

        add(actionPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JLabel getTemaLabel() {
        return temaLabel;
    }

    public JTextArea getDescripcionArea() {
        return descripcionArea;
    }

    public JButton getSiguienteButton() {
        return siguienteButton;
    }

    public JButton getGithubButton() {
        return githubButton;
    }

    public JButton getAtrasButton() {
        return atrasButton;
    }

    public InicioVista getParentWindow() {
        return parentWindow;
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeConfirmacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }
}