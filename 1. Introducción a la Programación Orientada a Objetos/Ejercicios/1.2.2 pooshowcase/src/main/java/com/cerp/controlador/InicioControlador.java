package com.cerp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import com.cerp.modelo.Tema;
import com.cerp.vista.AdminVista;
import com.cerp.vista.InicioVista;
import com.cerp.vista.TemaVista;

public class InicioControlador implements ActionListener {
    private List<Tema> modelo;
    private InicioVista vista;

    public InicioControlador(List<Tema> modelo, InicioVista vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getItemAdmin().addActionListener(this);
        vista.getItemTemas().addActionListener(this);

        ActualizarControlador();
    }

    public void ActualizarControlador() {
        vista.getLabelTemas().setText("Hay en el sistema " + modelo.size() + " temas");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getItemAdmin()) {
            AdminVista vistaAdmin = new AdminVista(vista);
            new AdminControlador(modelo, vistaAdmin, vista);
            vista.setVisible(false);
        } else if (e.getSource() == vista.getItemTemas()) {
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "No hay temas cargados en el sistema.", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }
            TemaVista vistaTema = new TemaVista(vista);
            new TemaControlador(modelo, vistaTema, vista);
            vista.setVisible(false);
        }
    }

    public List<Tema> getModelo() { return modelo; }
    public void setModelo(List<Tema> modelo) { this.modelo = modelo; }

    public void guardarTemas() {
        try {
            vista.getFileHandler().listToFile(modelo);
            System.out.println("Guardados " + modelo.size() + " temas en archivo.");
        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}