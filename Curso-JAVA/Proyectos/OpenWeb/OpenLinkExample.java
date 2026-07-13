package Proyectos.OpenWeb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class OpenLinkExample extends JFrame {

    public OpenLinkExample() {
        // Creación del botón
        JButton button = new JButton("Abrir enlace");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openWebpage("https://1001problemas.com/");
            }
        });

        // Añadiendo el botón al JFrame
        this.add(button);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private static void openWebpage(String urlString) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                URI uri = new URI(urlString);
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(uri);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new OpenLinkExample();
    }
}
