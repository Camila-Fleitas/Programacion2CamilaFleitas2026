package POOConceptos;

import javax.swing.*;

import PreguntasDelCursoMVC.FileHandler;
import PreguntasDelCursoMVC.Randomizer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @file ConceptoVista.java
 * @brief Clase que define la interfaz gráfica de usuario para mostrar preguntas y opciones de respuesta.
 * @date 2023-03-22
 * @version 1.0
 */

/**
 * @class ConceptoVista
 * @brief Clase que define la interfaz gráfica de usuario para mostrar preguntas y opciones de respuesta.
 */
public class ConceptoVista extends JFrame implements ActionListener {
    private JLabel idLabel;
    private JLabel preguntaLabel;
    private JLabel opcionesLabel;
    private JLabel correctaLabel;
    private JButton siguienteButton;
    private JButton confirmarButton;
    private JButton atrasButton;

    private List<Concepto> modelo;
    // Agregar atributo InicioVista llamado parentWindow
    private InicioVista parentWindow;

    /**
     * Botones para seleccionar las opciones de respuesta.
     */
    private JRadioButton[] answerButtons;
    private ButtonGroup buttonGroup;

    private int correctIndex;

    /**
     * Constructor de la clase AdminGUI.
     * @param modelo la lista de preguntas existente.
     * @param fileHandler el manejador de archivos a utilizar.
     */
    public ConceptoVista(FileHandler<Concepto> fileHandler, InicioVista parentWindow) {
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
        this.parentWindow = parentWindow; // Asignar el objeto recibido al atributo parentWindow


        // Configuración de la ventana
        setTitle("Juego de preguntas para Programación 3 - CeRP del Suroeste - Prof. Domingo Pérez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Panel para mostrar la pregunta
        JPanel preguntaPanel = new JPanel();
        preguntaPanel.setLayout(new BoxLayout(preguntaPanel, BoxLayout.Y_AXIS));
        preguntaPanel.setPreferredSize(new Dimension(600, 50)); // especificar una altura fija

        // Configuración de los componentes
        idLabel = new JLabel("ID de pregunta: " + "num");
        idLabel.setBounds(20, 20, 200, 20);
        preguntaPanel.add(idLabel, BorderLayout.CENTER);

        preguntaLabel = new JLabel("Concepto:");
        preguntaLabel.setBounds(20, 50, 80, 20);
        preguntaPanel.add(preguntaLabel, BorderLayout.CENTER);


        opcionesLabel = new JLabel("Etiquetas:");
        opcionesLabel.setBounds(20, 80, 80, 20);
        preguntaPanel.add(opcionesLabel, BorderLayout.CENTER);

        correctaLabel = new JLabel("Respuesta correcta:");
        correctaLabel.setBounds(20, 110, 140, 20);
        preguntaPanel.add(correctaLabel, BorderLayout.CENTER);


        add(preguntaPanel, BorderLayout.CENTER);

        // Crear el panel de respuestas
        JPanel answerPanel = new JPanel();
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // agregar márgenes
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));

        answerButtons = new JRadioButton[5];
        buttonGroup = new ButtonGroup();

        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JRadioButton("Opción " + (i + 1));
            answerButtons[i].setActionCommand(Integer.toString(i));
            buttonGroup.add(answerButtons[i]);
            answerPanel.add(answerButtons[i]);
        }

        add(answerPanel, BorderLayout.SOUTH);

        //Primer pregunta
        // Crear un objeto Randomizer para obtener un elemento aleatorio de la lista
        Randomizer<Concepto> randomizer = new Randomizer<>();
        // Obtener un elemento aleatorio de la lista de preguntas
        Concepto currentQuestion = randomizer.getRandomElement(modelo);
        
        idLabel.setText("ID de pregunta: " + currentQuestion.getIdConcepto());
        String correctAnswer = currentQuestion.getDescripcion();
        preguntaLabel.setText(currentQuestion.getConcepto());
        int correctButtonIndex = Randomizer.getRandomIndex(0, answerButtons.length - 1);
        //int correctButtonIndex = (int) (Math.random() * (answerButtons.length));
        answerButtons[correctButtonIndex].setText(correctAnswer);
        int optionIndex = 0;
        for (int i = 0; i < answerButtons.length; i++) {
            if (i == correctButtonIndex) {
                continue;
            }
            String option = currentQuestion.getEtiquetas()[optionIndex];
            answerButtons[i].setText(option);  

            optionIndex++;
        }

        
        // Panel para mostrar los botones de acción
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        siguienteButton = new JButton("Siguiente");
        siguienteButton.setBounds(150, 170, 100, 30);
        siguienteButton.addActionListener(this);

        confirmarButton = new JButton("Confirmar");
        confirmarButton.setBounds(260, 170, 100, 30);
        confirmarButton.addActionListener(this);

        atrasButton = new JButton("Atrás");
        atrasButton.setBounds(20, 170, 100, 30);
        atrasButton.addActionListener(this);

        actionPanel.add(siguienteButton);
        actionPanel.add(confirmarButton);
        actionPanel.add(atrasButton);

        add(actionPanel, BorderLayout.SOUTH);


    }

    
    /**
     * Acción a realizar cuando se presiona un botón en la interfaz.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == siguienteButton) {
            int numPregunta = Randomizer.getRandomIndex(0, modelo.size() - 1);
            Concepto currentQuestion = modelo.get(numPregunta);
            String correctAnswer = currentQuestion.getDescripcion();
            idLabel.setText("ID de pregunta: " + currentQuestion.getIdConcepto());
            preguntaLabel.setText(currentQuestion.getConcepto());
            int correctButtonIndex = Randomizer.getRandomIndex(0, answerButtons.length - 1);
            this.correctIndex = correctButtonIndex;
            //int correctButtonIndex = (int) (Math.random() * (answerButtons.length));
            answerButtons[correctButtonIndex].setText(correctAnswer);
            int optionIndex = 0;
            for (int i = 0; i < answerButtons.length; i++) {
                if (i == correctButtonIndex) {
                    continue;
                }
                String option = currentQuestion.getEtiquetas()[optionIndex];
                if (option.equals(correctAnswer)) {
                    optionIndex++;
                }
                answerButtons[i].setText(option);
                optionIndex++;
            }
                
            buttonGroup.clearSelection();

        } else if (e.getSource() == confirmarButton) {
            int selectedAnswer = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
                if (selectedAnswer==this.correctIndex){
                    JOptionPane.showMessageDialog(ConceptoVista.this, "¡Correcto!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(ConceptoVista.this, "¡Incorrecto!" + selectedAnswer + this.correctIndex , "Resultado", JOptionPane.ERROR_MESSAGE);
                }
            
        } else if (e.getSource() == atrasButton) {
            parentWindow.setVisible(true); // Hacer visible la ventana InicioVista
            dispose();
        }
        //pack(); // Ajustar tamaño al contenido
        //setResizable(false); // No permitir redimensionar
    }

        
}