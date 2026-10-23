package com.cerp.controlador;

import com.cerp.modelo.Tema;
import com.cerp.vista.InicioVista;
import com.cerp.vista.TemaVista;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.util.List;

public class TemaControlador implements ActionListener {
    private List<Tema> modelo;
    private TemaVista vista;
    private InicioVista vistaInicio2;
    private int indiceActual = 0;

    public TemaControlador(List<Tema> modelo, TemaVista vista, InicioVista vistaInicio) {
        this.modelo = modelo;
        this.vista = vista;
        this.vistaInicio2 = vistaInicio;

        // Escuchar los eventos de los tres botones de la vista
        if (vista.getSiguienteButton() != null) {
            vista.getSiguienteButton().addActionListener(this);
        }
        if (vista.getGithubButton() != null) {
            vista.getGithubButton().addActionListener(this);
        }
        if (vista.getAtrasButton() != null) {
            vista.getAtrasButton().addActionListener(this);
        }

        mostrarTemaActual();

        this.vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInicio2.getControlador().guardarTemas();
                System.exit(0);
            }
        });
    }

    private void mostrarTemaActual() {
        if (modelo == null || modelo.isEmpty()) {
            return;
        }

        Tema temaVisible = modelo.get(indiceActual);

        // Actualizar el título y el cuadro de texto blanco
        if (vista.getIdLabel() != null) {
            vista.getIdLabel().setText("ID de tema: " + temaVisible.getIdTema());
        }
        if (vista.getTemaLabel() != null) {
            vista.getTemaLabel().setText("Tema: " + temaVisible.getTema());
        }
        if (vista.getDescripcionArea() != null) {
            // Carga la descripción extensa ingresada en el panel de administración
            vista.getDescripcionArea().setText(temaVisible.getCorrecta());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getSiguienteButton()) {
            indiceActual = (indiceActual + 1) % modelo.size();
            mostrarTemaActual();

        } else if (e.getSource() == vista.getGithubButton()) {
            Tema temaVisible = modelo.get(indiceActual);
            
            // Obtener la URL guardada en el primer elemento del arreglo de opciones
            if (temaVisible.getOpciones() != null && temaVisible.getOpciones().length > 0) {
                String url = temaVisible.getOpciones()[0];
                try {
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        Desktop.getDesktop().browse(new URI(url));
                    }
                } catch (Exception ex) {
                    vista.mostrarMensajeError("Error al abrir enlace: " + ex.getMessage());
                }
            } else {
                vista.mostrarMensajeError("No hay enlace a GitHub registrado para este tema.");
            }

        } else if (e.getSource() == vista.getAtrasButton()) {
            vistaInicio2.setVisible(true);
            vista.dispose();
        }
    }
}