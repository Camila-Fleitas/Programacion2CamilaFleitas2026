package com.cerp.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import com.cerp.modelo.Tema;
import com.cerp.vista.AdminVista;
import com.cerp.vista.InicioVista;

/**
 * Controlador para la administración de temas.
 */
public class AdminControlador implements ActionListener {
    private List<Tema> modelo;
    private AdminVista vista;
    private InicioVista vistaInicio2;

    public AdminControlador(List<Tema> modelo, AdminVista vista, InicioVista vistaInicio) {
        this.modelo = modelo;
        this.vista = vista;
        this.vistaInicio2 = vistaInicio;

        vista.getConfirmarButton().addActionListener(this);
        vista.getAtrasButton().addActionListener(this);
        vista.getLimpiarButton().addActionListener(this);

        this.vista.actualizarIdLabel(modelo.size());
        limpiarFormulario();

        this.vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                vistaInicio2.getControlador().guardarTemas();
                System.exit(0);
            }
        });
    }

    private void limpiarFormulario() {
        vista.actualizarTemaField();
        vista.actualizarDescripcionField();
        vista.actualizarGithubField();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getConfirmarButton()) {
            if (vista.getTemaField().getText().trim().isEmpty() || 
                vista.getDescripcionField().getText().trim().isEmpty() || 
                vista.getGithubField().getText().trim().isEmpty()) {
                
                vista.mostrarMensajeError("Debe completar todos los campos.");
            } else {
                vista.getConfirmarButton().setEnabled(false);

                String titulo = vista.getTemaField().getText().trim();
                String descripcion = vista.getDescripcionField().getText().trim();
                String urlGithub = vista.getGithubField().getText().trim();

                // El constructor de Tema espera: (int idTema, String tema, String correcta, String[] opciones)
                String[] opciones = new String[]{ urlGithub };
                Tema nuevoTema = new Tema(modelo.size() + 1, titulo, descripcion, opciones);

                this.modelo.add(nuevoTema);
                vistaInicio2.getControlador().ActualizarControlador();

                vista.mostrarMensajeConfirmacion("Tema agregado correctamente.");
                vista.actualizarIdLabel(modelo.size());
                limpiarFormulario();

                vista.getConfirmarButton().setEnabled(true);
            }
        } else if (e.getSource() == vista.getAtrasButton()) {
            vista.getParentWindow().setVisible(true);
            vista.dispose();
        } else if (e.getSource() == vista.getLimpiarButton()) {
            modelo.clear();
            vistaInicio2.getControlador().ActualizarControlador();
            vista.actualizarIdLabel(modelo.size());
            limpiarFormulario();
            vista.mostrarMensajeConfirmacion("Lista limpiada.");
        }
    }
}