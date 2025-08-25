package org.ejemplo.interfaz;


import com.mparrastia.frases.GestorFraseDelDia;
import org.ejemplo.estructuras.Frase;



public class Main {
    public static void main(String[] args) {
        GestorFraseDelDia gestorFraseDelDia = new GestorFraseDelDia();
        Frase fraseDelDia = gestorFraseDelDia.obtenerfraseDelDia();
        System.out.println("Frase del dia: " + fraseDelDia.getFrase() + " por " + fraseDelDia.getAutor());


    }
}
