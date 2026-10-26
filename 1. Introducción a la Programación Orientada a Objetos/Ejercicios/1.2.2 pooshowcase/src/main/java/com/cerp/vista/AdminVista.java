package com.cerp.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @file AdminVista.java
 * @brief Clase para representar la interfaz gráfica de administración de temas.
 * @date 20/03/2023
 * @version 1.0
 */
public class AdminVista extends JFrame {
    private JLabel idLabel;
    private JLabel temaLabel;
    private JTextField temaField;
    private JLabel descripcionLabel;
    private JTextField descripcionField;
    private JLabel githubLabel;
    private JTextField githubField;
    private JButton confirmarButton;
    private JButton atrasButton;
    private JButton limpiarButton;

    private InicioVista parentWindow;

    public AdminVista(InicioVista parentWindow) {
        this.parentWindow = parentWindow;
        initComponents();
    }

    private void initComponents() {
        setTitle("Panel de Administración de Temas - POOShowcase");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel temaPanel = new JPanel();
        temaPanel.setLayout(new BoxLayout(temaPanel, BoxLayout.Y_AXIS));
        temaPanel.setPreferredSize(new Dimension(600, 50));

        idLabel = new JLabel("ID de tema: 1");
        idLabel.setBounds(20, 20, 200, 20);
        temaPanel.add(idLabel);

        temaLabel = new JLabel("Concepto / Tema:");
        temaLabel.setBounds(20, 50, 120, 20);
        temaPanel.add(temaLabel);

        temaField = new JTextField();
        temaField.setBounds(100, 50, 300, 20);
        temaPanel.add(temaField);

        descripcionLabel = new JLabel("Descripción extensa:");
        descripcionLabel.setBounds(20, 80, 140, 20);
        temaPanel.add(descripcionLabel);

        descripcionField = new JTextField();
        descripcionField.setBounds(100, 80, 300, 20);
        temaPanel.add(descripcionField);

        githubLabel = new JLabel("Enlace a GitHub:");
        githubLabel.setBounds(20, 110, 140, 20);
        temaPanel.add(githubLabel);

        githubField = new JTextField();
        githubField.setBounds(160, 110, 240, 20);
        temaPanel.add(githubField);

        add(temaPanel, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        confirmarButton = new JButton("Confirmar");
        atrasButton = new JButton("Atrás");
        limpiarButton = new JButton("Limpiar");

        actionPanel.add(confirmarButton);
        actionPanel.add(atrasButton);
        actionPanel.add(limpiarButton);

        add(actionPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actualizarIdLabel(int tam) {
        idLabel.setText("ID de tema: " + (tam + 1));
    }

    public InicioVista getParentWindow() {
        return parentWindow;
    }

    public JButton getConfirmarButton() {
        return confirmarButton;
    }

    public JButton getAtrasButton() {
        return atrasButton;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }

    public JTextField getTemaField() {
        return temaField;
    }

    public JTextField getDescripcionField() {
        return descripcionField;
    }

    public JTextField getGithubField() {
        return githubField;
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeConfirmacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actualizarTemaField() {
        temaField.setText("");
    }

    public void actualizarDescripcionField() {
        descripcionField.setText("");
    }

    public void actualizarGithubField() {
        githubField.setText("");
    }
}