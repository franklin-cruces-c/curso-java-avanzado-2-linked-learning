package org.ejemplo.modular.interfaz;


import org.ejemplo.modular.estructuras.Frase;
import org.ejemplo.modular.frases.GestorFraseDelDia;

/*
 * Proyecto creado de forma clásica
 * Desde Java 9 se puede tambien trabajar con modulos
 */
public class Main {
    public static void main(String[] args) {
        GestorFraseDelDia gestorFraseDelDia = new GestorFraseDelDia();
        Frase fraseDelDia = gestorFraseDelDia.obtenerfraseDelDia();
        System.out.println("Frase del dia: " + fraseDelDia.getFrase() + " por " + fraseDelDia.getAutor());

    }
}
