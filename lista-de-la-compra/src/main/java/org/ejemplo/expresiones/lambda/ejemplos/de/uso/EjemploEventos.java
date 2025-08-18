package org.ejemplo.expresiones.lambda.ejemplos.de.uso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploEventos {
    public static void main(String[] args) {
        JButton show =  new JButton("Mostrar");
        // Forma Clasica
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Mostrando...");
            }
        });

        //Con expresiones Lambda
        show.addActionListener(e -> System.out.println("Mostrando ..."));
    }
}
